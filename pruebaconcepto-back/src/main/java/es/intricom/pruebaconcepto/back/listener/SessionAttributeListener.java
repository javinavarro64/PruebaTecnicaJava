package es.intricom.pruebaconcepto.back.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.Serializable;

/**
 *
 * Monitoriza que se introduce en la session
 *
 * @author areus
 */
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    private static final Logger LOG = LoggerFactory.getLogger(SessionAttributeListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getValue() != null && !(event.getValue() instanceof Serializable)) {
            LOG.warn("El atributo [" + event.getName() + "] añadido a la sesión [" + event.getSession().getId() + "] " +
                    "no és serializable");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if (event.getValue() != null && !(event.getValue() instanceof Serializable)) {
            LOG.warn("L'atribut [" + event.getName() + "] reemplaçat a la sessió [" + event.getSession().getId() + "] " +
                    "no és serializable");
        }
    }
}
