package springtest.di.ioc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("springtest/di/ioc/annotation/beans.xml");
		UserController userController = context.getBean(UserController.class);
		userController.register("zhangsan", "123abc");
	}

}
