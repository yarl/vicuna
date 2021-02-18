package cuploader;

/**
 *
 * @author Pawel
 */
@com.thoughtworks.xstream.annotations.XStreamAlias("template")
public class QuickTemplate {
    public String name;
    public String template;
    public boolean active;
    
    public QuickTemplate(String name, String template, boolean active) {
        this.name = name;
        this.template = template;
        this.active = active;
    }
}
