package cuploader;

import java.io.File;
import java.util.Arrays;
import javax.swing.filechooser.FileFilter;

public class FileFilters {

  public static AllFilter all = new AllFilter();
  public static XMLFilter session = new XMLFilter();
  public static ImgFilter images = new ImgFilter();
  public static DocsFilter documents = new DocsFilter();
  public static TxtFilter text = new TxtFilter();
  public static AVFilter multimedia = new AVFilter();

  public static class AllFilter extends FileFilter {

    public static String getExtension(String name) {
      int i = name.lastIndexOf('.');

      if (i > 0 && i < name.length() - 1) {
        return name.substring(i + 1).toLowerCase();
      } else {
        return "";
      }
    }

    public static boolean isMatching(String ext) {
      return Arrays.asList(exts).contains(ext);
    }

    public static boolean isMatching(String ext, String[] exts) {
      return Arrays.asList(exts).contains(ext);
    }

    final static String[] exts = {"png", "gif", "jpg", "jpeg", "tiff", "tif", "xcf", "mid", "ogg", "ogv", "pdf", "svg", "djvu", "oga", "flac", "wav", "webm"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return isMatching(getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      return Data.text("loading-filter-all");
    }
  }

  public static class XMLFilter extends FileFilter {

    final String[] exts = {"xml"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return AllFilter.isMatching(AllFilter.getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      return Data.text("session-file") + " (*.xml)";
    }
  }

  public static class AVFilter extends FileFilter {

    final String[] exts = {"mid", "ogg", "ogv", "oga", "flac", "wav", "webm"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return AllFilter.isMatching(AllFilter.getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      String desc = Data.text("loading-filter-media") + " (";
      for (String ext : exts) {
        desc += "*." + ext + ", ";
      }
      return desc.substring(0, desc.length() - 2) + ")";
    }
  }

  public static class ImgFilter extends FileFilter {

    final String[] exts = {"png", "gif", "jpg", "jpeg", "svg", "tiff", "tif", "xcf"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return AllFilter.isMatching(AllFilter.getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      String desc = Data.text("loading-filter-img") + " (";
      for (String ext : exts) {
        desc += "*." + ext + ", ";
      }
      return desc.substring(0, desc.length() - 2) + ")";
    }
  }

  public static class DocsFilter extends FileFilter {

    final String[] exts = {"djvu", "jpg", "pdf"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return AllFilter.isMatching(AllFilter.getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      String desc = Data.text("loading-filter-scan") + " (";
      for (String ext : exts) {
        desc += "*." + ext + ", ";
      }
      return desc.substring(0, desc.length() - 2) + ")";
    }
  }

  public static class TxtFilter extends FileFilter {

    final String[] exts = {"txt"};

    @Override
    public boolean accept(File f) {
      if (f.isDirectory()) {
        return true;
      }
      return AllFilter.isMatching(AllFilter.getExtension(f.getName()), exts);
    }

    @Override
    public String getDescription() {
      return Data.text("settings-program-descfile-file") + " (*.txt)";
    }
  }
}
