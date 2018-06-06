package springtest.exercise1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("springtest/exercise1/beans.xml");
		UserController userController = context.getBean(UserController.class);
		userController.register("zhangsan", "123456");
	}

}
