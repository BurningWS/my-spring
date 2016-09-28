package ws.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by wangsong on 16-9-28.
 */
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().getName();
        long l = System.currentTimeMillis();
        System.out.printf("invocation of method '%s' start!\n", name);
        Object proceed = invocation.proceed();
        double time = (System.currentTimeMillis() - l) * 1.0 / 1000;
        System.out.printf("invocation of method '%s' end! cost %.4fs\n", name, time);
        return proceed;
    }
}
