package cuploader;

import javax.swing.*;

import java.awt.*;
import java.beans.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * This class cointain fileds with program settings. This stuff will be serialized and read after next start.
 *
 * @author Pawel
 * @author saper
 */
@com.thoughtworks.xstream.annotations.XStreamAlias("settings")
public class Settings {
    private transient PropertyChangeSupport propchange;

    //User
    public String server = "commons.wikimedia.org";
    public String username = "";

    public String protocol = "http";
    public String path = "/w";

    //SETTINGS
    //General
    public String author = "own";
    public String source = "";
    public String permission = "";
    public int license = 0;
    public String licenseCustom = "";
    public String attribution = "";
    public String categories = "";
    public String extraText = "";

    //File
    public ArrayList<QuickTemplate> quickTemplates = new ArrayList<QuickTemplate>();

    public boolean copyName = true;
    public boolean copyDescription = true;
    public boolean copyCategories = true;

    public boolean showCatHints = true;

    //Gallery
    public boolean createGallery = true;
    public String galleryPage = "gallery";
    public int galleryHeader = 0;
    public int galleryWidth = 200;
    public boolean galleryOnTop = false;

    //Program
    public boolean readExifHour = false;
    public boolean loadSubdirectory = false;
    public boolean renameAfterUpload = false;
    private boolean serverMonitorEnabled = true;
    public boolean askQuit = true;
    public String uploadSummary = "";

    public int fileDescSource = 0;
    public String fileDescPath = "";

    public String defaultDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();

    //WINDOW POSITION
    public Dimension windowSize;
    public Point windowPosition;

    //FILE EDIT
    public String numFormat = "%NAME% (%N%)";
    public int numDigits = 2;

    public ImmutableCoordinate coor = null;
    public int coorZoom = 0;

    //OTHER
    public Locale lang;

    public Settings() {
        this.propchange = new PropertyChangeSupport(this);
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-en"), "{{en|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-de"), "{{de|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-fr"), "{{fr|%TEXT%}}", true));
    }

    public boolean isServerMonitorEnabled() {
        return serverMonitorEnabled;
    }
    public void setServerMonitorEnabled(boolean n) {
        if (propchange == null) {
          propchange = new PropertyChangeSupport(this);
        }
        boolean old = serverMonitorEnabled;
        serverMonitorEnabled = n;
        propchange.firePropertyChange("checkDataBaseLag", old, n);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (propchange == null) {
          propchange = new PropertyChangeSupport(this);
        }
        propchange.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (propchange == null) {
          propchange = new PropertyChangeSupport(this);
        }
        propchange.removePropertyChangeListener(listener);
    }
}
