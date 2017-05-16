package uk.ac.standrews.cs;

import uk.ac.standrews.cs.logs.Fluentd;
import uk.ac.standrews.cs.logs.Log4j;

import java.io.File;
import java.io.IOException;

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
            try {
                instance = createLogInstance(logger, File.createTempFile("app-", ".log").getAbsolutePath());
            } catch (IOException e) {
                return null;
            }
        }

        return instance;
    }

    public static LOG LOG(final String logger, String filepath) {
        if (instance == null) {
            Logger.filepath = filepath;
            instance = createLogInstance(logger, filepath);
        }

        return instance;
    }

    private static LOG createLogInstance(String logger, String logPath) {

        System.setProperty("logfile.name", logPath);

        LOG log = null;
        switch (logger) {
            case FLUENTD_LOGGER:
                log = new Fluentd();
                break;
            case LOG4J_LOGGER:
                if (Logger.filepath != null) {
                    log = new Log4j(Logger.filepath);
                } else {
                    log = new Log4j();
                }
                break;
        }

        if (log != null) {
            System.out.println("Log at path: " + logPath);
            log.log(LEVEL.INFO.toString(), "Log will be stored at path " + logPath);
        }

        return log;
    }

    private static LOG createLogInstance() {
        try {
            return createLogInstance(DEFAULT_LOGGER, File.createTempFile("app-", ".log").getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
