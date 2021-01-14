package cuploader;

import cuploader.ImmutableCoordinate;

/**
 * This class cointain fileds for file structures for session.
 *
 * @author Michal Josef Špaček (User:Skim)
 */
@com.thoughtworks.xstream.annotations.XStreamAlias("sessionFile")
public class SessionFile {
    public String date = null;
    public String path = null;
    public String cats = null;
    public String name = null;
    public ImmutableCoordinate coor = null;
    public String desc = null;

    public SessionFile(String date, String path, String cats, String name,
        ImmutableCoordinate coor, String desc) {

        this.date = date;
        this.path = path;
        this.cats = cats;
        this.name = name;
        this.coor = coor;
        this.desc = desc;
    }

    public String getDate() {
        return this.date;
    }

    public String getPath() {
        return this.path;
    }

    public String getCats() {
        return this.cats;
    }

    public String getName() {
        return this.name;
    }

    public ImmutableCoordinate getCoordinate() {
        return this.coor;
    }

    public String getDesc() {
        return this.desc;
    }
}
