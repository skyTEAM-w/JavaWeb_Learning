package com.test;

import com.junit.Caculator;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    /**
     * 初始化方法
     * 用于资源申请，所以测试方法在执行前都会执行该方法
     */
    @BeforeEach
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源方法
     * 在测试方法执行之后自动执行
     */
    @AfterEach
    public void close() {
        System.out.println("close...");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
//        System.out.println("被执行了");
        //1.创建计算器对象
        Caculator c = new Caculator();
        //2.调用add方法
        int result = c.add(1, 2);
        System.out.println(result);

        //3.断言结果
        Assertions.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        Caculator caculator = new Caculator();
        int result = caculator.sub(1, 2);
        Assertions.assertEquals(-1, result);
    }
}
