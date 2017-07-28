# Loggers

A wrapper for a bunch of loggers

## Usage example:

```
log = Logger.LOG(Logger.LOG4J_LOGGER, "myapp.log");
log.log("TAG", LEVEL.INFO, "caller", "This is a log message");
log.log("TAG", LEVEL.INFO, "This is a log message without caller");
log.log("TAG", LEVEL.ERROR, "This an ERROR log message");
```

## Options

Available loggers:

- stdout: this is the default logger, if none is specified
- log4j
- fluentd: fluentd server must be available


Available levels:

- INFO
- DEBUG
- WARN
- ERROR
