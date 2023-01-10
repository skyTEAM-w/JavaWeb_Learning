package com.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * <p>
 * 当主方法执行后，会自动执行被检测的方法，判断方法是否有异常
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        //获取字节码文件对象
        Class<? extends Calculator> calculatorClass = calculator.getClass();

        int number = 0; //出现异常的次数
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        //获取所有方法
        for (Method classMethod : calculatorClass.getMethods()) {
            //判断是否含有注解
            if (classMethod.isAnnotationPresent(Check.class)) {
                try {
                    classMethod.invoke(calculator);
                } catch (Exception e) {
                    //捕获异常
                    bufferedWriter.write(classMethod.getName() + "方法出异常了");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常原因：" + e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("-------------------");
                    bufferedWriter.newLine();
                    number++;
                }
            }
        }
        bufferedWriter.write("本次测试一共出现"+number+"次异常");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
