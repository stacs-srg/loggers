package uk.ac.standrews.cs.logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public class LoggerTest {

    @AfterMethod
    public void tearDown() {
        Logger.DESTROY();
    }

    @Test
    public void getLOGTest() {
        LOG log = Logger.LOG();
        assertNotNull(log);
    }

    @Test
    public void logHelloWorld() {
        LOG log = Logger.LOG();
        log.log("test-default-out", "Hello World");
    }

    @Test
    public void useCustomLoggerTest() {
        LOG log = Logger.LOG(Logger.LOG4J_LOGGER);
        log.log("test-log4j", "hello world");
    }

    @Test
    public void useCustomLoggerWithLevelTest() {
        LOG log = Logger.LOG(Logger.LOG4J_LOGGER);
        log.log("test-log4j", LEVEL.ERROR,"hello world");
    }

    @Test
    public void useConsoleLoggerWithLevelTest() {
        LOG log = Logger.LOG(Logger.STDOUT_LOGGER);
        log.log("test-out", LEVEL.INFO,"hello world");
    }
}