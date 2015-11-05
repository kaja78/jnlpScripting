package org.kh.jnlpScripting;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;

public class PivotMain implements Application {
    private Window window = null;

    @Override
    public void startup(Display display, Map<String, String> properties) throws Exception {
        BXMLSerializer bxmlSerializer = new BXMLSerializer();
        this.window = (Window) bxmlSerializer.readObject(Window.class,"/org/kh/jnlpScripting/Window.bxml");
        this.window.open(display);
    }

    @Override
    public boolean shutdown(boolean optional) {
        if (this.window != null) {
            this.window.close();
        }

        return false;
    }

    @Override
    public void suspend() {
        // empty block
    }

    @Override
    public void resume() {
        // empty block
    }

    // useful to run this as a Java Application in a simpler way (directly)
    public static void main(String[] args) {
        DesktopApplicationContext.main(PivotMain.class, args);
    }

}
