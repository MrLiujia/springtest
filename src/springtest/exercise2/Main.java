package springtest.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		StudentController studentController = context.getBean(StudentController.class);
		studentController.list();
	}

}
