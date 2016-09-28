package ws.spring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangsong on 16-9-28.
 */
public class JdkDynamicProxy implements AopProxy, InvocationHandler {

    private AdvicedSupport advicedSupport;

    public JdkDynamicProxy(AdvicedSupport advicedSupport) {
        this.advicedSupport = advicedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advicedSupport.getTargetSource().getTargetClass()}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor interceptor = advicedSupport.getMethodInterceptor();
        Object invoke = interceptor.invoke(new ReflectiveMethodInvocation(advicedSupport.getTargetSource().getTarget(), method, args));
        return invoke;
    }
}
