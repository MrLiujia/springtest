package springtest.di.ioc.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserController userController = context.getBean(UserController.class);
		userController.register("zhangsan", "123abc");
	}

}
