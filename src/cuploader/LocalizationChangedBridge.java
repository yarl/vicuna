package cuploader;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LocalizationChangedBridge implements PropertyChangeListener {
    LocalizationChangedListener inner;

    public LocalizationChangedBridge(LocalizationChangedListener listener) {
        java.util.logging.Logger.getLogger(LocalizationChangedBridge.class.getName())
            .log(java.util.logging.Level.FINEST, "Bridge created: " + this.toString());
        this.inner = listener;
    }

    public Boolean supports(LocalizationChangedListener listener) {
        return this.inner == listener;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        java.util.logging.Logger.getLogger(LocalizationChangedBridge.class.getName())
            .log(java.util.logging.Level.FINEST, "Bridge called");
        if (evt.getPropertyName().equals("lang")) {
            this.inner.localizationChanged((java.util.Locale)evt.getNewValue());
        }
    }
}
