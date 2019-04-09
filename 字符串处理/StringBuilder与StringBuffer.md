StringBuilder与StringBuffer都继承AbstractStringBuilder类, 并且基本上所有的method都是通过super调用父类实现的.
两者之间的区别在于StringBuffer的method被synchronized声明, 线程安全.
- 相同之处:
    1. 都被final声明, 无法被继承
	2. 都继承AbstractStringBuilder, 拥有相同的业务逻辑.
	3. 相比String的不可变长度, 其通过byte数组实现对String的封装, 对内存更友好
- 不同点
	1. StringBuffer被synchronized声明, 线程安全.
	2. StringBuilder速度优于StringBuffer.
----
- StringBuffer源码摘抄
```java
package java.lang;

public final class StringBuffer
    extends AbstractStringBuilder
    implements java.io.Serializable, Comparable<StringBuffer>, CharSequence {

	@Override
    @HotSpotIntrinsicCandidate
    public synchronized StringBuffer append(String str) {
        toStringCache = null;
        super.append(str);
        return this;
    }
}
```
- StringBuilder源码摘抄
```java
package java.lang;

public final class StringBuilder
    extends AbstractStringBuilder
    implements java.io.Serializable, Comparable<StringBuilder>, CharSequence {
	
	@Override
    @HotSpotIntrinsicCandidate
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }
}

```