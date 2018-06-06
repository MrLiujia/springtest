package springtest;

public class Main {

	public static void main(String[] args) {
		// 手动注入
		// 注意初始化的顺序跟依赖的顺序相反
		C c = new C();
		
		B b = new B();
		b.setC(c);
		
		A a = new A(b);
		
		a.a();
	}

}
