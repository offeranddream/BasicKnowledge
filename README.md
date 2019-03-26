必须会的基本知识点：
----
1. Java语言基础:

    1.1 一些基础问题：

        1.1.1 如何判断一个对象是否属于某种类型 insteanceOf
        1.1.2 this和super
        1.1.3 加载顺序（初级应该用不到吧）JVM static
        1.1.4 基本数据类型和包装类
        1.1.5 equals和==的区别 5 == new Integer(5); 129 == new Integer(129);
        1.1.6 接口和父类
        1.1.7 Java中private、protected、public和default的区别
	|N/A|Inside class|This package|Subclass|External package|
	|---------|:----:|:----:|:----:|:----:|
	|public   |true  |true  |true  |true  |
	|protected|true  |true  |true  |false |
	|default  |true  |true  |false |false |
	|private  |true  |false |false |false |
	```java
	package demo.test.mainpackage;

	import java.util.UUID;

	public class Book {
	    private String id;
	    protected String price;
	    String desc;
	    public String name;

	    public Book() {}

	    public void print() {
		System.out.printf("id: %s, price: %s, desc: %s, name: %s", this.id, this.price, this.desc, this.name);
	    }

	    public static void main(String[] args) {
		Book book = new Book();
		book.id = UUID.randomUUID().toString();
		book.price = "24.00";
		book.desc = "This is my book";
		book.name = "A GLORAL HISTORY";
		book.print();
	    }
	}
	```
	```java
	package demo.test.mainpackage;

	import java.util.UUID;

	public class SamePackage {
	    public static void main(String[] args) {
		Book book = new Book();
		book.id = UUID.randomUUID().toString(); //编译错误
		book.price = "24.00";
		book.desc = "This is my book";
		book.name = "A GLORAL HISTORY";
		book.print();
	    }
	}
	```
	```java
	package demo.test.children;

	import java.util.UUID;
	import demo.test.mainpackage.Book;

	public class Inherit extends Book {

	    public static void main(String[] args) {
		Inherit book = new Inherit();
		book.id = UUID.randomUUID().toString(); // 编译错误
		book.price = "24.00";
		book.desc = "This is my book";          // 编译错误
		book.name = "A GLORAL HISTORY";
		book.print();
	    }
	}
	```
	```java
	package demo.test.otherpackage;

	import java.util.UUID;
	import demo.test.mainpackage.Book;

	public class DifferentPackage {
	    public static void main(String[] args) {
		Book book = new Book();
		book.id = UUID.randomUUID().toString(); // 编译错误
		book.price = "24.00";                   // 编译错误
		book.desc = "This is my book";          // 编译错误
		book.name = "A GLORAL HISTORY";
		book.print();
	    }
	}
	```
	      
    1.2 字符串处理：

        1.2.1 indexOf
        1.2.2 subString
        1.2.3 StringBuilder / StringBuffer
        1.2.4 常量池 String a = "123"; String b = new String("123");等

    1.3 集合类：

        1.3.1 常用集合类特性介绍
        1.3.2 HashMap实现原理和哈希算法
        1.3.3 ConcurrentHashMap特性和原理（高级/多线程语境必掌握）
        1.3.4 循环中如何删除map中的数据
        1.3.5 常用集合类API（CRUD + 排序）

    1.4 异常：

        1.4.1 异常种类
        1.4.2 异常处理
        1.4.3 异常和错误有何不同

    1.5 其他特性：

        1.5.1 如何判断两个对象相等
        1.5.2 异常及其处理
        1.5.3 IO/NIO
        1.5.4 File

2. Spring：

    2.1 简述IoC和AOP

    2.2 常用注解

    2.3 JPA

    2.4 springboot用法和带来的好处

    2.5 spring生成的类是单例的吗

    2.5 springMVC

    2.6 当请求进入springboot应用，会发生什么（进阶）

3. 数据结构和基本算法：

	3.1 链表

	3.2 数组

	3.3 图

4. HTTP协议：

    4.1 常用的方法

    4.2 get/post区别

5. SQL：

6. 设计模式：

    常用设计模式

    使用场景

7. 编程能力（除了考察解决问题的能力还要考察代码质量和编码习惯）：

	7.1 将字符串变成int

	7.2 按类中的int型字段排序

	7.3 查找一个数字在数组中的位置
	
8. 学习能力（好奇心）

	对JDK演进的了解

	最近学习的新技术
	
9. 逻辑能力：

	用一个新概念来诱导
	
10. 沟通能力

	你为什么要从上一家公司离职

	你为什么要到我们这里来

	你对未来的计划是什么

	你觉得自己有什么优势应聘这个岗位
	
11. 最后你对我们有什么问题：

	不要问有没有通过

	不要问薪水（确认通过后再和HR谈）

	不要问太大的问题如公司未来几年的规划（存疑）
