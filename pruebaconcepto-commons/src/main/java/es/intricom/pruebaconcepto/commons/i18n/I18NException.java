package es.intricom.pruebaconcepto.commons.i18n;

import java.util.Locale;

/**
 * Excepció que permet emprar missatges traduïbles.
 * Emprarà una instància de {@link I18NTranslator} per traduir els missatges.
 * Les subclasses han d'implementar el mètode {@link #getTranslator()} per indicar
 * la instància a emprar per traduir els missatges.
 */
public abstract class I18NException extends Exception {

    private static final long serialVersionUID = -3124602547590507219L;

    private Object[] parameters;

    public Object[] getParameters() {
        return parameters;
    }

    /**
     * Crea una excepción con un mensaje traducible.
     * @param message etiqueta del mensaje a traducir.
     */
    public I18NException(String message) {
        super(message);
    }

    /**
     * Crea una excepción con un mensaje traducible y los parámetros indicados.
     * @param message etiqueta del mensaje a traducir.
     * @param parameters paràmetros del mensaje.
     */
    public I18NException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    /**
     * Crea una excepción con un mensaje traducible .
     * @param cause excepción original
     * @param message etiqueta del mensaje a traducir.
     */
    public I18NException(Throwable cause, String message) {
        super(message, cause);
    }

    /**
     * Crea una excepción con un mensaje traducible y los parametros indicadoss.
     * @param cause excepción original
     * @param message etiqueta del mensaje a traducir.
     * @param parameters paràmetres del missatge.
     */
    public I18NException(Throwable cause, String message, Object... parameters) {
        super(message, cause);
        this.parameters = parameters;
    }

    /**
     * Proporciona la instància de {@link I18NTranslator} que se usará
     * para traducir los mensajes.
     * @return instancia para traducir los mensajes.
     */
    protected abstract I18NTranslator getTranslator();

    /**
     * Retorna el missatge de l'excepció traduit en l'idioma per defecte, {@link Locale#getDefault()}.
     * @return missatge traduit.
     */
    @Override
    public String getLocalizedMessage() {
        return getLocalizedMessage(Locale.getDefault());
    }

    /**
     * Retorna el missatge de l'excepció traduit en l'idioma indicat.
     * @param locale idioma per traduir.
     * @return missatge traduit.
     */
    public String getLocalizedMessage(Locale locale) {
        return getTranslator().translate(locale, super.getMessage(), parameters);
    }
}
