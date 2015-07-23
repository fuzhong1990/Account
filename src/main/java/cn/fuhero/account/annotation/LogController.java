package cn.fuhero.account.annotation;

import java.lang.annotation.*;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogController {
    String description()  default "";
}
