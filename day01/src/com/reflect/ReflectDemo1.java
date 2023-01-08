package com.reflect;

import com.domain.Person;

public class ReflectDemo1 {
    /**
     * 获取Class的三种方式
     * Class.ForNaame("全类名"):用于配置文件
     * 类名。class：用于参数传递
     * 对象.getClass()：多用于对象获取字节码的方式
     */
    public static void main(String[] args) throws Exception {
        // 1
        Class aClass = Class.forName("com.domain.Person");
        System.out.println(aClass);
        // 2
        Class personClass = Person.class;
        System.out.println(personClass);
        // 3
        Person p = new Person();
        Class aClass1 = p.getClass();
        System.out.println(aClass1);

        System.out.println(aClass == personClass);
        System.out.println(aClass1 == aClass);
    }
}
