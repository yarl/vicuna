package cuploader;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.KeyStroke;

/**
 *
 * @author Pawel
 */
/**
 * Some components treat tabulator (TAB key) in their own way.
 * Sometimes the tabulator is supposed to simply transfer the focus
 * to the next focusable component.
 * <br/>
 * Here s how to use this class to override the "component's default"
 * behavior:
 * <pre>
 * JTextArea  area  = new JTextArea(..);
 * <b>TransferFocus.patch( area );</b>
 * </pre>
 * This should do the trick. 
 * This time the KeyStrokes are used.
 * More elegant solution than TabTransfersFocus().
 * 
 * @author kaimu
 * @since 2006-05-14
 * @version 1.0
 */
public class TransferFocus {

    /**
     * Patch the behaviour of a component. 
     * TAB transfers focus to the next focusable component,
     * SHIFT+TAB transfers focus to the previous focusable component.
     * 
     * @param c The component to be patched.
     */
    public static void patch(Component c) {
        Set<KeyStroke> 
        strokes = new HashSet<KeyStroke>(Arrays.asList(KeyStroke.getKeyStroke("pressed TAB")));
        c.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, strokes);
        strokes = new HashSet<KeyStroke>(Arrays.asList(KeyStroke.getKeyStroke("shift pressed TAB")));
        c.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, strokes);
    }
}