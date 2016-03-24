package cuploader;

import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    public License license = License.CC_BY_SA_3;
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

    //Validation
    public boolean checkPrefixBlacklist = true;
    public boolean checkIfExists = true;
    public boolean checkGPS = false;
    public boolean checkUniqueNames = true;
 
    //WINDOW POSITION
    public Dimension windowSize;
    public Point windowPosition;

    //FILE EDIT
    public String numFormat = "%NAME% (%N%)";
    public int numDigits = 2;

    public ImmutableCoordinate coor = null;
    public int coorZoom = 0;

    //OTHER
    private Locale lang;

    public Settings() {
        propchange = new PropertyChangeSupport(this);
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

    public Locale getLang() {
        return lang;
    }
    public void setLang(Locale l) {
        if (propchange == null) {
          propchange = new PropertyChangeSupport(this);
        }
        Locale old = lang;
        lang = l;
        propchange.firePropertyChange("lang", old, l);
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

    public void addLocalizationChangedListener(LocalizationChangedListener listener) {
        propchange.addPropertyChangeListener(new LocalizationChangedBridge(listener));
    } 

    public void removeLocalizationChangedListener(LocalizationChangedListener listener) {
        for (PropertyChangeListener p : propchange.getPropertyChangeListeners()) {
            if (p instanceof LocalizationChangedBridge) {
               if (((LocalizationChangedBridge)p).supports(listener)) {
                  propchange.removePropertyChangeListener(p);
               }
              }
        }
    }

    /**
     * Read after the object is de-serialized, also by XStream
     * Useful to fill in empty fields
     */
    private Object readResolve() {
        java.util.logging.Logger.getLogger(Settings.class.getName())
          .log(java.util.logging.Level.FINER, "readResolve() called");
        propchange = new PropertyChangeSupport(this);
        initializeLocale();
        return this;
    }

    public void initializeLocale() {
        if (lang == null) {
           lang = Locale.getDefault();
        } else {
           Locale.setDefault(lang);
        }
    }

    public String getLicenseString() {
        if (License.OTHER.equals(license)) {
            return licenseCustom;
        } else if (attribution.isEmpty()) {
            return license.getTemplate().replace("|%ATTRIB%", "");
        } else {
            return license.getTemplate().replace("%ATTRIB%", attribution);
        }
    }
}
