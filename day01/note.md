# JavaWeb学习打卡Day1
## Junit测试
      ①	 步骤
      定义一个测试类（eg: CalculatorTest）
      定义测试方法 (eg:testAdd()  , 返回值void，参数列表空参)
      给方法加@Test
      导入junit依赖
      ②	判定结果
      红色失败，绿色成功。
      使用断言判断处理结果：Assert.assertEquals(期望的结果，运算的结果)
      ③	 @Before和 @After
      @Before修饰的方法会在测试方法之前被自动执行
      @After修饰的方法会在测试方法执行之后自动执行 （无论测试方法结果是否正确）
## 反射
      说明：其将类的各个组成部分封装为其他对象。

### 获取Class对象的三种方式:
①	Class.forName(“全类名”)
多用于配置文件，将类名定义在配置文件中，读取文件，加载类。

②	类名.class
多用于参数的传递。

③	对象.getClass()
多用于对象获取字节码的方式

结论：同一个字节码文件（.class）在一次程序运行过程中，只会被加载一次，无论通过哪一种方式获取Class对象都是同一个。

## Class对象功能：
①	获取成员变量

Field[] getFields: 获取public修饰的成员变量

Field getField(String name)   (获取公共的public)

Field[] getDeclaredFields()

Field getDeclaredField(String name)

②	获取构造方法

Constructor[] getConstructors()

Constructor<T> getConstructor(类名，参数)

③	获取成员方法

Method【 】 getMethods()

Method getMethod()

④	获取类名

String getName()

**Field成员变量**

1. 设置值 void set(Object obj, Object Value)

2. 获取值 get(Object obj)

3. 忽略访问权限修饰符的安全检查

setAccessible(true)  暴力反射

## Constructor:构造方法
创建对象

T newInstance(Object …)

如果使用无参构造方法创建对象：Class对象的newInstance方法。

### 案例

需求：写一个框架，不改变该类的任何代码，可以创建任意类。并且执行其中的任意方法

实现：

1. 配置文件
2. 反射

步骤
1. 将需要创建的对象的类全程和需要执行的方法定义在配置文件中
2. 在程序中加载读取配置文件
3. 使用反射计数加载类文件进内存
4. 创建对象
5. 执行方法

## 注解

概念：说明程序的，给计算机看

定义：Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。
Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java 标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字
节码中。Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。

作用：

    @Override - 检查该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
    @Deprecated - 标记过时方法。如果使用该方法，会报编译警告。
    @SuppressWarnings - 指示编译器去忽略注解中声明的警告。
    @Retention - 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
    @Documented - 标记这些注解是否包含在用户文档中。
    @Target - 标记这个注解应该是哪种 Java 成员。
    @Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
    @SafeVarargs - Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
    @FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。
    @Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。

### 自定义注解

格式：

    元注解
    public @interface 注解名称{}

本质：就是一个接口，默认集成Annotation接口

```java
public interface com.annotation.MyAnno extends java.lang.annotation.Annotation {
}
```

属性：接口中可以定义的成员方法，接口中的抽象方法

要求：

1. 属性的返回值类型
   1. 基本数据类型
   2. String
   3. 枚举
   4. 注解
   5. 以上类型的数组
2. 定义了属性，在使用时需要给属性赋值
   1. 如果定义属性时使用default初始化，则不需赋值
   2. 只有一个属性需赋值时，且名称为value直接写值即可
   3. 数组赋值时用{}包裹，只有一个值时可省略

### 元注解

描述注解的注解

   * @Target：描述注解能够作用的位置
   * @Retention：描述注解被保留的阶段
   * @Documented：描述注解是否被抽取到api文档中
   * @Inherited：描述注解是否被子类继承


   
