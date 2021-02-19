package cuploader;

/**
 *
 * @author Pawel
 */
@com.thoughtworks.xstream.annotations.XStreamAlias("source")
public class DescSource {
    public String name;
    public String desc;
    
    public DescSource(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
