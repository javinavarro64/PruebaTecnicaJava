package es.intricom.pruebaconcepto.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * Bean para mantener el idioma en el usuario.
 *
 * @author areus
 */
@Named
@SessionScoped
public class UserLocale implements Serializable {

    private static final long serialVersionUID = -3709390221710580769L;

    private static final Logger LOG = LoggerFactory.getLogger(UserLocale.class);

    @Inject
    private FacesContext context;

    /** Locale actual del usuario */
    private Locale current;

    public Locale getCurrent() {
        return current;
    }

    public void setCurrent(Locale current) {
        this.current = current;
    }



    /**
     * Inicialización del idioma del usuario.
     */
    @PostConstruct
    private void init() {
        LOG.info("Inicialización del idioma del usuario.");
        Application app = context.getApplication();
        current = app.getViewHandler().calculateLocale(context);
    }

    public void reload() {
        context.getPartialViewContext().getEvalScripts()
                .add("location.replace(location)");
    }
}
