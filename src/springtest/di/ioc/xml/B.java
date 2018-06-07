package springtest.di.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 使用前需要setC
 * @author Administrator
 *
 */
@Component
public class B {
//	@Autowired //也可以写在字段上面
	private C c;
	
	public C getC() {
		return c;
	}

	// setter注入，缺点是依赖的声明没那么明显，往往需要在文档中说明依赖关系
	// spring会分析加了@Autowired注解的setters，得出需要注入哪些依赖
	@Autowired
	public void setC(C c) {
		this.c = c;
	}

	public void b() {
		
		System.out.println("ioc xml b");
		c.c();
	}
}
