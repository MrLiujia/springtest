package springtest.di.manual;

public class A {
	
	private B b;
	
	// 构造方法是一种很好的声明依赖的方式，尤其适合于编写类库时用
	// 构造器注入，通过参数列表来声明依赖，并且在new的时候编译器会强制注入，new完就可以用
	public A(B b) {
		this.b = b;
	}

	public void a() {
		System.out.println("a");
		b.b();
	}

}
