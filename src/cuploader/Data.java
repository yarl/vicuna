package cuploader;

import cuploader.frames.Main;
import java.awt.GridBagConstraints;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Data implements Serializable {
    public static String version;
    public static String date;
    
    public enum Elem {
        NAME, EXT, DATE, COOR, DESC, CATS;
    }
    public static boolean isLogged = false;
    
    //help vars
    public static double sizeToUpload = 0;
    public static boolean ctrlPress = false;
    public static boolean shiftPress = false;
    public static boolean isLoadSession = false;
    public static String[][] loadSessionData;
    
    public static Coordinate coor = null;
    public static int coorZoom = 0;
    
    //storage info
    private static ArrayList<PFile> files = new ArrayList<PFile>();       //stores all images
    
    public static int filesUpload = 0;
    public static int filesEdit = 0;
    
    public static ArrayList<String> licenses = new ArrayList<String>();
    public static ArrayList<String> licensesTemplates = new ArrayList<String>();

    
    //public ResourceBundle text;
    
    public Data(String version, String date) {
        Data.version = version;
        Data.date = date;
        
        //text = ResourceBundle.getBundle("messages", locale);

        licenses.add("Creative Commons BY-SA 3.0");             licensesTemplates.add("cc-by-sa 3.0");
        licenses.add("Creative Commons BY 3.0");                licensesTemplates.add("cc-by 3.0");
        licenses.add("GNU Free Documentation License (GFDL)");  licensesTemplates.add("GFDL");
        licenses.add("Inna...");                                licensesTemplates.add(null);
    }

    public static void updateFileCounter() {
        DecimalFormat df = new DecimalFormat("##.##");
        Main.lFileUpload.setText(filesUpload + " / " + files.size() + " (" + df.format(sizeToUpload) + " MiB)");
    }
    
    public static void addPanel(PFile p) {
        GridBagConstraints gbc = new GridBagConstraints();
        //ogranicznik.insets = new Insets(5, 10, 5, 5);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0; //files.size()%2;
        gbc.gridy = files.size();///2;

        files.add(p);
        Main.pFiles.add(p, gbc);
        updateFileCounter();
    }
    
    //get
    public static ArrayList<PFile> getFiles() {
        return files;
    }

    public static int getFirstFileEdit() {
        for (int i = 0; i < files.size(); ++i) {
            if (files.get(i).toEdit) {
                return i;
            }
        }
        return -1;
    }
}
