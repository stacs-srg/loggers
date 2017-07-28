package uk.ac.standrews.cs.logger.logs;

import org.fluentd.logger.FluentLogger;
import uk.ac.standrews.cs.logger.LEVEL;
import uk.ac.standrews.cs.logger.LOG;

import java.util.HashMap;
import java.util.Map;

public class Fluentd extends LOG {

    private static FluentLogger LOG;
    private static final String DEFAULT_LOGNAME = "fluentd";

    private Fluentd(String logname) {
        LOG = FluentLogger.getLogger(logname);
    }

    public Fluentd() {
        this(DEFAULT_LOGNAME);
    }

    @Override
    public void log(String tag, LEVEL level, String message) {
        Map<String, Object> data = new HashMap<>();
        data.put("Level", level.toString());
        data.put("Message" ,message);
        try {
            LOG.log(tag, data);
        } catch(Exception e) { /* Ignore */ }
    }

    @Override
    public void log(String tag, LEVEL level, String caller, String message) {
        Map<String, Object> data = new HashMap<>();
        data.put("Level", level.toString());
        data.put("Caller", caller);
        data.put("Message", message);
        try {
            LOG.log(tag, data);
        } catch(Exception e) { /* Ignore */ }
    }

    @Override
    public void log(String tag, String message) {
        log(tag, LEVEL.INFO, message);
    }

}