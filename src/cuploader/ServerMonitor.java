package cuploader;

import cuploader.Data;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
      if (this.monitor != null) {
        if (!this.monitor.isAlive()) {
          start();
        }
      } else {
        start();
      }
    } else {
      if (this.monitor != null) {
        if (this.monitor.isAlive()) {
          stop();
        }
      }
    }
  }

  public void propertyChange(PropertyChangeEvent evt) {
    boolean enabled = this.data.settings.isServerMonitorEnabled();
    boolean loggedIn = this.data.isLoggedIn();

    if (evt.getPropertyName() == "serverMonitorEnabled") {
      enabled = (Boolean)evt.getNewValue();
    }
    if (evt.getPropertyName() == "loggedIn") {
      loggedIn = (Boolean)evt.getNewValue();
    }
    startStop(loggedIn, enabled);
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
