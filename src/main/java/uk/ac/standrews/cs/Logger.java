package uk.ac.standrews.cs;

import uk.ac.standrews.cs.logs.Fluentd;
import uk.ac.standrews.cs.logs.Log4j;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class Logger {

    private static LOG instance;
    private static String filepath;

    public static final String FLUENTD_LOGGER = "fluentd";
    public static final String LOG4J_LOGGER = "log4j";
    public static final String DEFAULT_LOGGER = FLUENTD_LOGGER;

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

    private static LOG createLogInstance(String logger) {
        switch (logger) {
            case FLUENTD_LOGGER:
                return new Fluentd();
            case LOG4J_LOGGER:
                if (Logger.filepath != null) {
                    return new Log4j(Logger.filepath);
                } else {
                    return new Log4j();
                }
            default:

        }

        return null;
    }

    private static LOG createLogInstance() {
        return createLogInstance(DEFAULT_LOGGER);
    }
}
