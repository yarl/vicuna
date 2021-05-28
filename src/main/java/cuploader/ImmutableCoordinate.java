package cuploader;

public class ImmutableCoordinate {
  private final double latitude;
  private final double longitude;
  private final String heading;

  public ImmutableCoordinate(double latitude, double longitude, String heading) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.heading = heading;
  }

  public ImmutableCoordinate(String latitude, String longitude, String heading) {
    this.latitude = Double.parseDouble(latitude.replace(",", "."));
    this.longitude = Double.parseDouble(longitude.replace(",", "."));
    this.heading = heading;
  }

  public double getLat() {
    return latitude;
  }

  public double getLon() {
    return longitude;
  }

  public String getHeading() {
    return heading;
  }
}
