package es.intricom.pruebaconcepto.ejb.interceptor;

import es.intricom.pruebaconcepto.service.exception.ResourceNotFoundException;
import es.intricom.pruebaconcepto.service.exception.ServiceException;

import javax.ejb.EJBException;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.io.Serializable;

/**
 * Interceptor Para capturar las excepciones.
 * Se pordrian sacar errores SQL en la capa de servicio
 *
 * @author areus
 */
@ExceptionTranslate
@Interceptor
public class ExceptionTranslatorInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Transforma lass excepcioness.
     *
     * @param context Contexto de la invocación.
     * @return El resultado del meétodo interceptado.
     * @throws Exception llanza la excepción procesada.
     */
    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        try {
            return context.proceed();
        } catch (PersistenceException persistenceException) {
            throw processPersistenceException(persistenceException);
        } catch (EJBException ejbException) {
            Throwable cause = ejbException.getCause();
            if (cause instanceof PersistenceException) {
                throw processPersistenceException((PersistenceException) cause);
            }
            throw ejbException;
        }
    }

    private ServiceException processPersistenceException(PersistenceException exception) {
        if (exception instanceof EntityNotFoundException) {
            return new ResourceNotFoundException();
        }
        return new ServiceException(exception);
    }
}
