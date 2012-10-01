package cuploader;

import java.io.Serializable;

/**
 *
 * @author Pawel
 */
public class QuickTemplate implements Serializable{
    public String name;
    public String template;
    public boolean active;
    
    public QuickTemplate(String name, String template, boolean active) {
        this.name = name;
        this.template = template;
        this.active = active;
    }
}