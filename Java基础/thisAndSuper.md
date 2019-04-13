- this用法
  1. this.attribute, 可调用当前对象的成员变量，一般是在当前类的某个方法的形参和当前的对象成员变量同名的时候用到
  2. this.method(), 可以调用当前对象的方法
  3. this(), 调用当前类的无参构造, 如果需要调用有参构造方法, 传入对应参数即可
- super用法
  1. super.attribute, 调用父类的成员变量
  2. super.method(), 调用父类的方法
  3. super(), 调用当前父类的无参构造, 如果需要调用有参构造方法, 传入对应参数即可
  
this()和super()都指的是对象, 所以, 均不可以在static环境中使用. 包括: static变量, static方法, static语句块
