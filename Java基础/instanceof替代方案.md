关于会问这道题的面试官, 也许他只是想看看大家对instanceof的理解, 毕竟只有学会了一, 才能反三
先上代码
```java
package demo.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReplaceInstanceof {

    public static void main(String[] args) {
        Object alist = new ArrayList<>();

        System.out.println(alist instanceof ArrayList); // true
        System.out.println(alist instanceof List); // true
        System.out.println(alist instanceof LinkedList); // false

        System.out.println(ArrayList.class.getName().equals(alist.getClass().getName())); // true
        System.out.println(List.class.getName().equals(alist.getClass().getName()));// false

        try {
            System.out.println((ArrayList)alist); // []
            System.out.println((List)alist);// []
            System.out.println((LinkedList)alist);// ClassCastException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```
首先通过打印instanceof判断的结果, 我们可以得知
> instanceof用于判断对象的类型是否是属于特定类的一个实例或者是否是该特定类的一个子类

通过className仅仅是字面比较, 它无法匹配父子类关系

强制转换在不抛出异常的情况下, 可以将对象的类型转为当前类型及其父类
