package myfirstproject.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day12_Log4JTest {

    private static Logger logger = LogManager.getLogger(Day12_Log4JTest.class.getName());

    @Test
    public void log4jTest() {

        logger.warn("Warning Log!");
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");


    }
}