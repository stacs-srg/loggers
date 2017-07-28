package uk.ac.standrews.cs.logger.logs;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import uk.ac.standrews.cs.logger.LEVEL;
import uk.ac.standrews.cs.logger.LOG;

import java.io.IOException;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class Log4j extends LOG {

    static Logger LOG;
    private static final String DEFAULT_LOGNAME = "A1";

    private Log4j(String logname, boolean toFile, String filepath) {
        LOG = Logger.getLogger(logname);

        if (toFile) {
            try {
                LOG.addAppender(new FileAppender(new PatternLayout(), filepath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Log4j() {
        this(DEFAULT_LOGNAME, false, null);
    }

    public Log4j(String filepath) {
        this(DEFAULT_LOGNAME, true, filepath);
    }

    @Override
    public void log(String tag, String message) {
        LOG.info(tag + " : " + message);
    }

    @Override
    public void log(String tag, LEVEL level, String message) {

        if (level == LEVEL.INFO) {
            LOG.info(tag + " : " + message);
        } else if (level == LEVEL.DEBUG) {
            LOG.debug(tag + " : " + message);
        } else if (level == LEVEL.ERROR) {
            LOG.error(tag + " : " + message);
        } else if (level == LEVEL.WARN) {
            LOG.warn(tag + " : " + message);
        }
    }

    @Override
    public void log(String tag, LEVEL level, String caller, String message) {

        if (level == LEVEL.INFO) {
            LOG.info(caller + " : " + tag + " : " + message);
        } else if (level == LEVEL.DEBUG) {
            LOG.debug(caller + " : " + tag + " : " + message);
        } else if (level == LEVEL.ERROR) {
            LOG.error(caller + " : " + tag + " : " + message);
        } else if (level == LEVEL.WARN) {
            LOG.warn(caller + " : " + tag + " : " + message);
        }
    }
}
