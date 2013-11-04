package cuploader;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileFilters {
    public static AllFilter all = new AllFilter();
    
    public static XMLFilter session = new XMLFilter();
    public static ImgFilter images = new ImgFilter();
    public static DocsFilter documents = new DocsFilter();
    public static TxtFilter text = new TxtFilter();
    public static AVFilter multimedia = new AVFilter();

    public static class AllFilter extends FileFilter {
        public static boolean isMatching(String ext) {
          if (ext.equals("png") || ext.equals("gif") || ext.equals("jpg") ||
              ext.equals("jpeg") || ext.equals("tiff") || ext.equals("tif") ||
              ext.equals("xcf") || ext.equals("mid") || ext.equals("ogg") ||
              ext.equals("ogv") || ext.equals("svg") || ext.equals("djvu") ||
              ext.equals("oga") || ext.equals("flac") || ext.equals("wav") ||
              ext.equals("webm"))
              return true;
          return false;
        }
      
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                s = s.substring(i + 1).toLowerCase();
                return isMatching(s);
            }
            return false;
        }

        @Override
        public String getDescription() {
            return Data.text("loading-filter-all");
        }
    }
    
    public static class XMLFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1)
                if (s.substring(i + 1).toLowerCase().equals("xml"))
                    return true;
            return false;
        }

        @Override
        public String getDescription() {
            return Data.text("session-file") + " (*.xml)";
        }
    }

    public static class AVFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                s = s.substring(i + 1).toLowerCase();
                if (s.equals("mid") || s.equals("ogg") || s.equals("ogv") ||
                    s.equals("oga") || s.equals("flac") || s.equals("wav") ||
                    s.equals("webm"))
                    return true;
            }
            return false;
        }
        
        @Override
        public String getDescription() {
            return Data.text("loading-filter-media") + " (*.mid, *.ogg, *.ogv, *.oga, *.flac, *.wav, *.webm)";
        }
    }
    
    public static class ImgFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                s = s.substring(i + 1).toLowerCase();
                if(s.equals("png") || s.equals("gif") || s.equals("jpg") ||
                   s.equals("jpeg") || s.equals("tiff") || s.equals("tif") ||
                   s.equals("xcf") || s.equals("svg"))
                    return true;
            }
            return false;
        }

        @Override
        public String getDescription() {
            return Data.text("loading-filter-img") + " (*.jpg, *.png, *.gif, *.tiff, *.svg, *.xcf)";
        }
    }

    public static class DocsFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                s = s.substring(i + 1).toLowerCase();
                if (s.equals("jpg") || s.equals("pdf") || s.equals("djvu"))
                    return true;
            }
            return false;
        }

        @Override
        public String getDescription() {
            return Data.text("loading-filter-scan") + " (*.jpg, *.pdf, *.djvu)";
        }
    }

    public static class TxtFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1)
                if (s.substring(i + 1).toLowerCase().equals("txt"))
                    return true;
            return false;
        }

        @Override
        public String getDescription() {
            return Data.text("settings-program-descfile-file") + " (*.txt)";
        }
    }
}
