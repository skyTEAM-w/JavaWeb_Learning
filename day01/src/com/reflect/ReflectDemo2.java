package com.reflect;

import com.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    /**
     * Class 对象功能
     */
    public static void main(String[] args) throws Exception {
        // 1.获取Person的Class对象
        Class personClass = Person.class;
        // 2.Field[] getField()
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----------");
        Field a = personClass.getField("a");

        //获取成员变量a的值；
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p, "张三");
        System.out.println(p.toString());
        System.out.println("=========");

        //Field[] getDeclaredFields()
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        // Field getDeclaredField(String name);
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检测
        d.setAccessible(true);  //暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);

        //构造方法
        //Constructor<T> getConstructor(class<?>...parameterTypes)
        System.out.println("----------------------");
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        System.out.println("----------------------");
        //成员方法
        //获取指定名称的方法
        Method eat = personClass.getMethod("eat");
        Person person = new Person();
        //执行方法
        eat.invoke(person);

        Method eat_method = personClass.getMethod("eat", String.class);
        eat_method.invoke(p, "饭");

        System.out.println("---------------------");

        //获取所以public方法
        Method[] methods = personClass.getMethods();

        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }
    }
}
