package uk.ac.standrews.cs.logger.logs;

import org.apache.log4j.Logger;
import uk.ac.standrews.cs.logger.LEVEL;
import uk.ac.standrews.cs.logger.LOG;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class Log4j extends LOG {

    static Logger LOG;

    public Log4j(String filepath) {
        LOG = Logger.getLogger(filepath);
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
