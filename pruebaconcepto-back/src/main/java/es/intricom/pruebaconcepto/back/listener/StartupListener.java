package es.intricom.pruebaconcepto.back.listener;

import es.intricom.pruebaconcepto.commons.utils.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Se ejecuta al inicio y al apagado del servidcr
 *
 * @author areus
 */
@WebListener
public class StartupListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(StartupListener.class);

    @Inject
    private Version version;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("\nWebApp " + version.getProjectName() + ":"
                + "\n  + Version: " + version.getVersion()
                + "\n  + BuildTime: " + version.getBuildTime()
                + "\n  + Revision: " + version.getScmRevision());
    }

    /**
     * Executat quan es destrueix el contexte web.
     *
     * @param sce Informació de l'esdeveniment de context.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Aturant aplicació " + version.getProjectName());
    }
}
