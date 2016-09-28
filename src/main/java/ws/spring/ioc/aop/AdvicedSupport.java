package ws.spring.ioc.aop;

import lombok.Getter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by wangsong on 16-9-28.
 */
public class AdvicedSupport {
    @Getter
    TargetSource targetSource;
    @Getter
    MethodInterceptor methodInterceptor;

    public AdvicedSupport(TargetSource targetSource, MethodInterceptor methodInterceptor) {
        this.targetSource = targetSource;
        this.methodInterceptor = methodInterceptor;
    }
}
