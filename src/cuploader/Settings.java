package cuploader;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * This class cointain fileds with program settings. This stuff will be serialized and read after next start.
 *
 * @author Pawel
 */
public class Settings {
    //User
    public String server = "commons.wikimedia.org";
    public String username = "";

    public String protocol = "http";
    public String path = "/w";

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
    public boolean checkDatabaseLag = true;
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
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-en"), "{{en|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-de"), "{{de|%TEXT%}}", true));
        quickTemplates.add(new QuickTemplate(Data.text("file-wiki-fr"), "{{fr|%TEXT%}}", true));
    }
}
