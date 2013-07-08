package cuploader;

import java.text.DecimalFormat;

/**
 * TODO: merge with org.openstreetmap.gui.jmapviewer.Coordinate;
 * @author Pawel
 */

public class Coord {
    private double lat, lon;
    
    public Coord(String[] lat, String[] lon) {
        this.lat = Double.parseDouble(lat[0]) + (Double.parseDouble(lat[1])/60.0) + (Double.parseDouble(lat[2])/3600.0);
        this.lon = Double.parseDouble(lon[0]) + (Double.parseDouble(lon[1])/60.0) + (Double.parseDouble(lon[2])/3600.0);
    }
    
    public Coord(String[] lat, String NS, String[] lon, String EW) {
        if(NS.equals("N"))
            this.lat = Double.parseDouble(lat[0]) + (Double.parseDouble(lat[1])/60.0) + (Double.parseDouble(lat[2])/3600.0);
        if(NS.equals("S"))
            this.lat = -1 * (Double.parseDouble(lat[0]) + (Double.parseDouble(lat[1])/60.0) + (Double.parseDouble(lat[2])/3600.0));
        if(EW.equals("E"))
            this.lon = Double.parseDouble(lon[0]) + (Double.parseDouble(lon[1])/60.0) + (Double.parseDouble(lon[2])/3600.0);
        if(EW.equals("W")) {
            this.lon = -1 * (Double.parseDouble(lon[0]) + (Double.parseDouble(lon[1])/60.0) + (Double.parseDouble(lon[2])/3600.0));
        }
    }
    
    public Coord(String lat, String lon) {
        this.lat = Double.parseDouble(lat);
        this.lon = Double.parseDouble(lon);
    }
    
    public Coord(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    
    public String[] getDM() {
        String[] text = new String[2];
        
        int D = (int)Math.abs(lat);
        int M = (int)((Math.abs(lat)-D)*60.0);
        
        if(lat<0)
            text[0] = D + "° " + M + "\' S";
        else  
            text[0] = D + "° " + M + "\' N";
        
        D = (int)(lon);
        M = (int)((lon-D)*60.0);
        text[1] = D + "° " + M + "\' E";
        
        return text;       
    }
    
    public String[] getDMS() {
        String[] text = new String[2];
        DecimalFormat df = new DecimalFormat("#.##");
        
        int D = (int)Math.abs(lat);
        int M = (int)((Math.abs(lat)-D)*60.0);
        double S = (((Math.abs(lat)-D)*60.0)-M)*60.0;//(Math.floor((lat-D)*60.0)-M)*60.0;
        
        text[0] = D + "° " + M + "\' " + df.format(S) + "\" ";        
        text[0] += (lat<0) ? "S" : "N";

        D = (int)Math.abs(lon);
        M = (int)((Math.abs(lon)-D)*60.0);
        S = (((Math.abs(lon)-D)*60.0)-M)*60.0;
        
        text[1] = D + "° " + M + "\' " + df.format(S) + "\" ";
        text[1] += (lon<0) ? "W" : "E";
        
        return text;       
    }
    
    public String getDMSformated() {
        return "<html><body>&nbsp;&nbsp;&nbsp;" + getDMS()[0] + "<br>&nbsp;&nbsp;&nbsp;" + getDMS()[1] + "</body></html>";
    }
    
    public String getDecimal() {
        return lat + ";" + lon;
    }
    
    public double getLat() {
        return lat;
    }
    
    public double getLon() {
        return lon;
    }
}