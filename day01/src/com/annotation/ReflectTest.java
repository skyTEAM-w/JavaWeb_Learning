package com.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "com.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //1.解析注解
        //1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2. 获取上边的注解对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        //3. 调用注解对象定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //3. 加载类进内存
        Class cls = Class.forName(className);
        //4. 创建对象
        Object obj = cls.newInstance();
        //5. 获取方法对象
        Method method = cls.getMethod(methodName);
        //6. 执行方法
        method.invoke(obj);
    }
}
