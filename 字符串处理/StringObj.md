关于这个问题其实隐藏了一个很小的陷阱在其中, 这个我们稍后再说

先逐行的分析代码
```java
String a = "abc";
```
对于上面的代码, 我们都可以很轻易的给出答案, 它在字符串常量池(java1.8后, 字符串常量被放在堆空间中)里创建了一个常量对象

不仅仅上面的写法创建了一个对象, 下面的写法也同样仅创建一个对象
```java
String a = "abc";
String b = "abc";
```
```java
String a = "a" + "b" + "c";
```
接下来再说说另一行代码
```java
String b = new String("abc");
```
这里也很好理解了, 当看到**new**关键字时, 我们知道一个String对象被创建, **"abc"**同样需要在字符串常量池中创建

就这样2个对象被创建出来了

现在回过头来我们在看看问题: 
> 执行了String a = "123"; String b = new String("123");这两句代码以后内存中有几个对象?
结果还是2个对象, 之所以如此, 则是因为**new String("123")**中的常量信息已经被创建出来, 所以在第二次使用时会使用之前创建好的常量对象

对于这样的情况, 我们可以通过**javap -c**去查看如下被编译后class文件, 反汇编解释
```java
package demo.string;

public class StringObj {

    String a = "abc";
    String b = new String("abc");
}
```
```java
Compiled from "StringObj.java"
public class demo.string.StringObj {
  java.lang.String a;

  java.lang.String b;

  public demo.string.StringObj();
    Code:
       0: aload_0
       1: invokespecial #11                 // Method java/lang/Object."<init>":()V
       4: aload_0
       5: ldc           #13                 // String abc
       7: putfield      #15                 // Field a:Ljava/lang/String;
      10: aload_0
      11: new           #17                 // class java/lang/String
      14: dup
      15: ldc           #13                 // String abc
      17: invokespecial #19                 // Method java/lang/String."<init>":(Ljava/lang/String;)V
      20: putfield      #22                 // Field b:Ljava/lang/String;
      23: return
}
```
ldc: 表示将常量池中的项压入栈

通过第5行与第15行之间的对比, 我们可以发现它们使用的是同样的常量

对于对javap -c 字节码含义感兴趣的同学, 可以点[这里][0]了解更多

[0]: https://www.cnblogs.com/faunjoe88/p/8126464.html
