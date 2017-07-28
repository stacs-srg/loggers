package uk.ac.standrews.cs.logger;

import uk.ac.standrews.cs.logger.logs.Fluentd;
import uk.ac.standrews.cs.logger.logs.Log4j;
import uk.ac.standrews.cs.logger.logs.Stout;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class Logger {

    private static LOG instance;
    private static String filepath;

    public static final String FLUENTD_LOGGER = "fluentd";
    public static final String LOG4J_LOGGER = "log4j";
    public static final String STDOUT_LOGGER = "stdout";
    public static final String DEFAULT_LOGGER = STDOUT_LOGGER;

    public static LOG LOG() {
        if (instance == null) {
            instance = createLogInstance();
        }

        return instance;
    }

    public static LOG LOG(final String logger) {
        if (instance == null) {
            instance = createLogInstance(logger);
        }

        return instance;
    }

    public static LOG LOG(final String logger, String filepath) {
        if (instance == null) {
            Logger.filepath = filepath;
            instance = createLogInstance(logger);
        }

        return instance;
    }

    public static void DESTROY() {
        instance = null;
    }

    private static LOG createLogInstance(String logger) {
        switch (logger) {
            case FLUENTD_LOGGER:
                return new Fluentd();
            case LOG4J_LOGGER:
                if (Logger.filepath != null) {
                    System.setProperty("logfile.name", Logger.filepath);
                    return new Log4j(Logger.filepath);
                } else {
                    System.setProperty("logfile.name", "test.log");
                    return new Log4j("test.log");
                }
            case STDOUT_LOGGER:
                return new Stout();
            default:

        }

        return null;
    }

    private static LOG createLogInstance() {
        return createLogInstance(DEFAULT_LOGGER);
    }
}
