package springtest.exercise6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		OperatorDao operatorDao = context.getBean(OperatorDao.class);
		
		System.out.println("findAll: " + operatorDao.findAll());
		System.out.println("findOne: " + operatorDao.findOne(1));
		
//		operatorDao.create("lisi", "123abc", "HR");
//		operatorDao.updatePassword(1, "123456");
//		operatorDao.disable(2);
	}

}
