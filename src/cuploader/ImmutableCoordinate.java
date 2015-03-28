package cuploader;

public class ImmutableCoordinate {
  private final double latitude;
  private final double longitude;

  public ImmutableCoordinate(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public ImmutableCoordinate(String latitude, String longitude) {
    this.latitude = Double.parseDouble(latitude);
    this.longitude = Double.parseDouble(longitude);
  }
  
  public double getLat() {
    return latitude;
  }

  public double getLon() {
    return longitude;
  }
}
