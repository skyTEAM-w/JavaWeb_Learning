package com.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
元注解
 */
@Target(value = {ElementType.TYPE}) //只能作用于类上
public @interface MyAnno3 {
}
