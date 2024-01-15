package es.intricom.pruebaconcepto.service.exception;

import java.util.Locale;

/**
 * Excepción que salta cuando no se encuentra la entidad
 *
 * @author areus
 */
public class ResourceNotFoundException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
    }

    @Override
    public String getLocalizedMessage(Locale locale) {
        return translate(locale, "error.recursNoTrobat");
    }
}

