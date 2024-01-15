package es.intricom.pruebaconcepto.service.exception;

import java.util.Locale;

/**
 * Excepción general de la capa de servicio.
 *
 * @author areus
 */
public class ServiceException extends AbstractServiceException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getLocalizedMessage(Locale locale) {
        return translate(locale, "error.intern");
    }
}
