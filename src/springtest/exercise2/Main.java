package springtest.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		StudentController studentController = context.getBean(StudentController.class);
		studentController.list();
		
		// -----------------------------------
		// 测试StudentDao的CRUD
		StudentDao studentDao = context.getBean(StudentDao.class);
		
		System.out.println("findOne: " + studentDao.findOne(1L));
		
//		studentDao.add(new Student(0L, "李四", Gender.Female, 18, "Java"));;
//		studentDao.delete(1L);
//		studentDao.update(new Student(4L, "张三", Gender.Male, 21, "UI"));
		// -----------------------------------
		
		// 也可以直接获取Environment来获得配置项（属性值）
		Environment env = context.getBean(Environment.class);
		String someConfig = env.getProperty("app.someConfig");
		System.out.println(someConfig);
	}

}
