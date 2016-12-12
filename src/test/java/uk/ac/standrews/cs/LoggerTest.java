package uk.ac.standrews.cs;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class LoggerTest {

    @Test
    public void getLOGTest() {
        LOG log = Logger.LOG();
        assertNotNull(log);
    }

    @Test
    public void logHelloWorld() {
        LOG log = Logger.LOG();
        log.log("test", "Hello World");
    }

    @Test
    public void useCustomLoggerTest() {
        LOG log = Logger.LOG(Logger.LOG4J_LOGGER);
        log.log("test", "hello world");
    }

    @Test
    public void useCustomLoggerWithLevelTest() {
        LOG log = Logger.LOG(Logger.LOG4J_LOGGER);
        log.log("test", LEVEL.ERROR,"hello world");
    }

}