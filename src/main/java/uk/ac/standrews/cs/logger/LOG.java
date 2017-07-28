package uk.ac.standrews.cs.logger;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public abstract class LOG {

    public abstract void log(String tag, String message);

    public abstract void log(String tag, LEVEL level, String message);

    public abstract void log(String tag, LEVEL level, String caller, String message);
}
