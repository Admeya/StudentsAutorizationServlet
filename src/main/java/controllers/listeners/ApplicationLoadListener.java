package controllers.listeners;

import controllers.LoginServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Ирина on 24.02.2017.
 */
public class ApplicationLoadListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ApplicationLoadListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.trace("Site started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.trace("Site stopped");
    }
}
