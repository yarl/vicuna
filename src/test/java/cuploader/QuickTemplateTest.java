/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cuploader;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickTemplateTest {
    @Test public void testConstructor() {
        QuickTemplate template =new QuickTemplate("","", false);
        assertEquals("",template.name);
        assertEquals("",template.template);
        assertEquals(false,template.active);
    }
}
