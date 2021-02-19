package cuploader;

import java.util.ArrayList;

/**
 * This class cointain fileds with files structures for sessions.
 *
 * @author Michal Josef Špaček (User:Skim)
 */
@com.thoughtworks.xstream.annotations.XStreamAlias("sessionList")
public class SessionList {
    public ArrayList<SessionFile> sessionFiles = new ArrayList<SessionFile>();

    public SessionList() {
    }

    public void addSessionFile(SessionFile sessionFile) {
        this.sessionFiles.add(sessionFile);
    }

    public ArrayList<SessionFile> getSessionFiles() {
        return this.sessionFiles;
    }
}
