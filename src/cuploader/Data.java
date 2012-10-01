package cuploader;

import cuploader.frames.*;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Data implements Serializable {
    public enum Elem { NAME, EXT, DATE, COOR, DESC, CATS; }
    
    //text
    public static ResourceBundle text;
    public static String text(String s){
        return text.getString(s);
    }
    
    public static UndoManager manager = new UndoManager();
    
    public static String version;
    public static String date;
    public static boolean isLogged = false;
    
    //windows
    public static FSettings fSettings;
    public static FAbout fAbout;
    public static FLogin fLogin;
    public static FUploadCheck fUploadCheck;
    public static FFileEdit fFileEdit;
    
    //help vars
    public static double sizeToUpload = 0;
    public static boolean ctrlPress = false;
    public static boolean shiftPress = false;
    public static boolean isLoadSession = false;
    public static String[][] loadSessionData;
      
    //storage info
    private static ArrayList<PFile> files = new ArrayList<PFile>();       //stores all images
    
    //counters
    public static int filesUpload = 0;
    public static int filesEdit = 0;
    
    //licenses
    public static ArrayList<String> licenses = new ArrayList<String>();
    public static ArrayList<String> licensesTemplates = new ArrayList<String>();
    
    //quick templates
    public static JPopupMenu mQuickTemplates = new JPopupMenu();
    
    public Data(String version, String date) {
        Data.version = version;
        Data.date = date;
        
        licenses.add("Creative Commons BY-SA 3.0");         licensesTemplates.add("{{cc-by-sa 3.0|%ATTRIB%}}");
        licenses.add("Creative Commons BY 3.0");            licensesTemplates.add("{{cc-by 3.0|%ATTRIB%}}");
        licenses.add("Creative Commons Zero 1.0");          licensesTemplates.add("{{cc-zero}}");
        licenses.add(text("license-gfdl-cc-by-sa-all"));    licensesTemplates.add("{{GFDL|migration=redundant}}{{cc-by-sa-all|%ATTRIB%}}");
        licenses.add(text("license-gfdl-cc-by-sa-3"));      licensesTemplates.add("{{GFDL|migration=redundant}}{{cc-by-sa 3.0|%ATTRIB%}}");
        licenses.add(text("license-gfdl-cc-by-3"));         licensesTemplates.add("{{GFDL|migration=redundant}}{{cc-by 3.0|%ATTRIB%}}");
        licenses.add(text("license-other"));                licensesTemplates.add("");
        
        refreshQuickTemplates();
    }
    
    /***
     * Updates upload counter in bottom right corner on main frame
     */
    public static void updateFileCounter() {
        DecimalFormat df = new DecimalFormat("##.##");
        int toUpload = 0;
        float toUploadSize = 0;
        
        for(PFile f : files) {
            if(f.toUpload) {
                ++toUpload;
                toUploadSize += 9.5367e-7*f.file.length();
            }
        }
        filesUpload = toUpload;
        Main.lFileUpload.setText(toUpload + " / " + files.size() + " (" + df.format(toUploadSize) + " MiB)");
    }
    
    /*
     * Quick templates stuff
     */
    public static void refreshQuickTemplates() {
        if(Settings.quickTemplates==null) {
            Settings.quickTemplates = new ArrayList<QuickTemplate>();
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-de"), "{{de|%TEXT%}}", true));
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-en"), "{{en|%TEXT%}}", true));
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-fr"), "{{fr|%TEXT%}}", true));
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-es"), "{{es|%TEXT%}}", false));
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-pl"), "{{pl|%TEXT%}}", true));
            Settings.quickTemplates.add(new QuickTemplate(text("file-wiki-ru"), "{{ru|%TEXT%}}", true));
        }
        
        mQuickTemplates.removeAll();
        for(final QuickTemplate qt : Settings.quickTemplates) {
            if(qt.active) {
                final JMenuItem item = new JMenuItem(qt.name);
                item.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        insertTemplate((JTextArea)((JPopupMenu)((JMenuItem)e.getSource()).getParent()).getInvoker(), Settings.quickTemplates.indexOf(qt));
                    }
                });
                mQuickTemplates.add(item);
            }
        }
    }
    
    static void insertTemplate(JTextArea textarea, int i) {
        String template = Settings.quickTemplates.get(i).template;
        String selection = textarea.getSelectedText();
        
        textarea.requestFocus();
        if(template.contains("%TEXT%")) {
            if(selection==null) {
                textarea.append(template.replace("%TEXT%", Data.text("file-wiki-text")));
                textarea.select(textarea.getText().indexOf(Data.text("file-wiki-text")), textarea.getText().indexOf(Data.text("file-wiki-text"))+Data.text("file-wiki-text").length());
            } else
                textarea.replaceSelection(template.replace("%TEXT%", selection));
        } else
            textarea.append(template);
    }
    
    /***
     * Adds file panel to main window
     * @param p file panel
     */
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