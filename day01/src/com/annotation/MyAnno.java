package com.annotation;

public @interface MyAnno {

//    public abstract String show();
    int value() default 1;
    String name() default "张三";

    Person per();
//
    MyAnno2 anno2();
//
    String[] strs();
}
