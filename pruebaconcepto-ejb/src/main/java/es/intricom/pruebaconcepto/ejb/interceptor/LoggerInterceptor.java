package es.intricom.pruebaconcepto.ejb.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Logged
@Interceptor
public class LoggerInterceptor implements Serializable {

    private static final long serialVersionUID = 7109011370027722074L;

    private static final Logger LOG = LoggerFactory.getLogger(LoggerInterceptor.class);


    @AroundInvoke
    public Object logCall(InvocationContext context) throws Exception {
        String simpleName = context.getTarget().getClass().getSimpleName();
        String methodName = simpleName + "." + context.getMethod().getName();
        boolean debugEnabled = LOG.isDebugEnabled();
        if (debugEnabled) {
            LOG.debug("{} {}", methodName, Arrays.toString(context.getParameters()));
        }

        long startTime = System.nanoTime();
        Object result = context.proceed();
        long duration = System.nanoTime() - startTime;

        if (debugEnabled) {
            LOG.debug("{} return({}) in {} ms", methodName, result, TimeUnit.NANOSECONDS.toMillis(duration));
        }
        return result;
    }
}
