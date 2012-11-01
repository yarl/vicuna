package cuploader;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFileChooser;
import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 * This class cointain fileds with program settings. This stuff will be serialized and read after next start.
 * @author Pawel
 */
public class Settings {
    //User
    public String server = "commons.wikimedia.org";
    public String username = "";
    
//SETTINGS
    //General
    public String author = "own";
    public String source = "";
    public int license = 0;
    public String licenseCustom = "";
    public String attribution = "";
    public String categories = "";
    public String extraText = "";

    //File
    public ArrayList<QuickTemplate> quickTemplates = new ArrayList<QuickTemplate>();
    
    public boolean copyName = false;
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
    public boolean askQuit = true;

    public int fileDescSource = 0;
    public String fileDescPath = "";
    
    public String defaultDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    
    //WINDOW POSITION
    public Dimension windowSize;
    public Point windowPosition;
    
    //FILE EDIT
    public String numFormat = "%NAME% (%N%)";
    public int numDigits = 2;
    
    public Coordinate coor = null;
    public int coorZoom = 0;
    
    //OTHER
    public Locale lang;

    public Settings() {
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-de"), "{{de|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-en"), "{{en|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-fr"), "{{fr|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-es"), "{{es|%TEXT%}}", false));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-pl"), "{{pl|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-ru"), "{{ru|%TEXT%}}", true));
    }
}
