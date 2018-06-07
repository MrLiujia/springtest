package springtest.di.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 将会被spring扫描到并自动注册为bean，没有“标记”的将被忽略，比如Main类
public class A {
	
	private B b;
	
	// 构造方法是一种很好的声明依赖的方式，尤其适合于编写类库时用
	// 构造器注入，通过参数列表来声明依赖，并且在new的时候编译器会强制注入，new完就可以用
	// spring会分析加了@Autowired注解的构造器，得出需要注入哪些依赖
	@Autowired // 自动装配 - 告诉spring需要构造器注入B
	public A(B b) {
		this.b = b;
	}

	public void a() {
		System.out.println("ioc xml a");
		b.b();
	}

}
