package cuploader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import cuploader.Data;
import cuploader.Data.Elem;
import static cuploader.Data.fSettings;
import static cuploader.Data.settings;
import cuploader.FileFilters;
import cuploader.PFile;
import cuploader.Settings;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wikipedia.Wiki;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ServerMonitor implements Runnable, PropertyChangeListener {
  public Data data;
  public JLabel lServerStatus;
  protected Thread monitor;

  public ServerMonitor(JLabel lServerStatus_, Data data_) {
    this.data = data_;
    this.lServerStatus = lServerStatus_;
  }

  public void statusIdle() {
    lServerStatus.setText(Data.text("server-status"));
    lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-offline.png")));
  }

  public void statusOffline() {
    lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-offline"));
    lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-offline.png")));
  }

  @Override
  public void run() {
    while (!this.monitor.interrupted()) {
        try {
          int lag;
          if (this.data.wiki != null && this.data.isLoggedIn()) {
            debug("Got wiki, logged in");
            lag = this.data.wiki.getCurrentDatabaseLag();

            if (lag <= 0) {
              lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status.png")));
              lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-ok"));
            } else if (lag > 0 && lag <= 5) {
              lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-away.png")));
              lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-lag") + " " + lag + " s");
            } else {
              lServerStatus.setIcon(new ImageIcon(getClass().getResource("/cuploader/resources/status-busy.png")));
              lServerStatus.setText(Data.text("server-status") + ": " + Data.text("server-lag") + " " + lag + " s");
            }
          }
        } catch (IOException ex) {
          statusOffline();
        }
      try {
        Thread.sleep(30000);
      } catch (InterruptedException ex) {
        statusIdle();
        return;
      }
      statusIdle();
    }
  }

  protected void startStop(boolean loggedIn, boolean enabled) {
    if (enabled && loggedIn) {
      if (!this.monitor.isAlive()) {
        start();
      }
    } else {
      if (this.monitor.isAlive()) {
        stop();
      }
    }
  }

  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getSource() instanceof Settings) {
      Settings settings = (Settings)evt.getSource();
      startStop(true, settings.isCheckDatabaseLag());
    } else {
      log.log(Level.SEVERE, "Uninteresting change for the ServerMonitor");
    }
  }

  public void start() {
    debug("ServerMonitor starting");
    this.monitor = new Thread(this);
    this.monitor.start();
  }

  public void stop() {
    debug("ServerMonitor will be stopped");
    this.monitor.interrupt();
    statusIdle();
  }

  protected static Logger log = Logger.getLogger(ServerMonitor.class.getName());

  protected static void debug(String s) {
    log.log(Level.INFO, s);
  }
}
