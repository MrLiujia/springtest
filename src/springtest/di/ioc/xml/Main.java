package springtest.di.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml"); // 创建组件容器
		A a = context.getBean(A.class); // 问容器要感兴趣的组件
		a.a();
	}

}
