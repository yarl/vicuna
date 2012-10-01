package cuploader;

import cuploader.frames.Main;
import java.awt.Dimension;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.wikipedia.Wiki;

/**
 * This class cointain fileds with program settings. This stuff will be serialized and read after next start.
 * @author Pawel
 */
public class Settings implements Serializable {
    
    public Settings() {}
    public static Wiki wiki;
    
    public static String server = "commons.wikimedia.org";
    public static String username = "";
    
    //SETTINGS
    //General
    public static String author = "own";
    public static String source = "";
    public static int license = 0;
    public static String licenseCustom = "";
    public static String attrib = "";
    public static String categories = "";
    public static String extratext = "";

    //File
    public static ArrayList<QuickTemplate> quickTemplates;
    
    //Gallery
    public static boolean createGallery = true;
    public static String galleryPage = "gallery";
    public static int galleryHeader = 0;
    public static int galleryWidth = 200;
    public static boolean galleryOnTop = false;

    //Program
    public static boolean readExifHour = false;
    public static boolean loadSubdirectory = false;
    public static boolean renameAfterUpload = false;
    public static boolean askQuit = true;

    public static int fileDescSource = 0;
    public static String fileDescPath = "";
    
    //WINDOW POSITION
    public static Dimension size;
    public static Point position;
    
    //FILE EDIT
    public static String numFormat = "%NAME% (%N%)";
    public static int numDigits = 2;
    
    public static Coordinate coor = null;
    public static int coorZoom = 0;
    
    //OTHER
    public static Locale lang;
    
    private void writeObject(ObjectOutputStream oos) throws IOException 
    {
        oos.defaultWriteObject();
        oos.writeObject(wiki);
        
        oos.writeObject(server);
        oos.writeObject(username);
        
        oos.writeObject(author);
        oos.writeObject(source);
        oos.writeObject(license);
        oos.writeObject(licenseCustom);
        oos.writeObject(attrib);
        oos.writeObject(categories);
        oos.writeObject(extratext);
        
        oos.writeObject(createGallery);
        oos.writeObject(galleryPage);
        oos.writeObject(galleryHeader);
        oos.writeObject(galleryWidth);
        oos.writeObject(galleryOnTop);
        
        oos.writeObject(readExifHour);
        oos.writeObject(loadSubdirectory);
        oos.writeObject(renameAfterUpload);
        oos.writeObject(askQuit);
        
        oos.writeObject(fileDescSource);
        oos.writeObject(fileDescPath);
        
        oos.writeObject(size);
        oos.writeObject(position);
        
        oos.writeObject(numFormat);
        oos.writeObject(numDigits);
        
        oos.writeObject(lang);
        oos.writeObject(quickTemplates);
        oos.writeObject(coor);
        oos.writeObject(coorZoom);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException 
    {
        ois.defaultReadObject();
        wiki = (Wiki)ois.readObject();
        
        server = (String)ois.readObject();
        username = (String)ois.readObject();
        
        author = (String)ois.readObject();
        source = (String)ois.readObject();
        license = (Integer)ois.readObject();
        licenseCustom = (String)ois.readObject();
        attrib = (String)ois.readObject();
        categories = (String)ois.readObject();
        extratext = (String)ois.readObject();
       
        createGallery = (Boolean)ois.readObject();
        galleryPage = (String)ois.readObject();
        galleryHeader = (Integer)ois.readObject();
        galleryWidth = (Integer)ois.readObject();
        galleryOnTop = (Boolean)ois.readObject();

        readExifHour = (Boolean)ois.readObject();
        loadSubdirectory = (Boolean)ois.readObject();
        renameAfterUpload = (Boolean)ois.readObject();
        askQuit = (Boolean)ois.readObject();
        
        fileDescSource = (Integer)ois.readObject();
        fileDescPath = (String)ois.readObject();
        
        size = (Dimension)ois.readObject();
        position = (Point)ois.readObject();
        
        numFormat = (String)ois.readObject();
        numDigits = (Integer)ois.readObject();
        
        lang = (Locale)ois.readObject();
        quickTemplates  = (ArrayList<QuickTemplate>)ois.readObject();
        coor = (Coordinate)ois.readObject();
        coorZoom = (Integer)ois.readObject();
    }
    
    public static void Serialize() {
        Settings s = new Settings();
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(".vicuna-settings"));
            out.writeObject(s);
            out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Saving error: " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
