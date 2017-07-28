package uk.ac.standrews.cs.logger.logs;

import uk.ac.standrews.cs.logger.LEVEL;
import uk.ac.standrews.cs.logger.LOG;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class Stout extends LOG {
    
    @Override
    public void log(String tag, String message) {
        System.out.println(tag + " - " + message);
    }

    @Override
    public void log(String tag, LEVEL level, String message) {
        System.out.println(level + " :: " + tag + " - " + message);
    }

    @Override
    public void log(String tag, LEVEL level, String caller, String message) {
        System.out.println(level + " :: " + caller + " :: " + tag + " - " + message);
    }
}
