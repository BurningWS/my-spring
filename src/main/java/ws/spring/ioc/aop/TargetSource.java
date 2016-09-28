package ws.spring.ioc.aop;

import lombok.Getter;

/**
 * Created by wangsong on 16-9-28.
 */
public class TargetSource {

    @Getter
    private Class targetClass; //类的接口
    @Getter
    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }
}
