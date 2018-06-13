package springtest.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springtest.aop.service.AService;
import springtest.aop.service.BService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		AService aService = context.getBean(AService.class);
		int plusResult = aService.plus(1, 2);
		System.out.println("1 + 2应该等于" + plusResult);
		
		BService bService = context.getBean(BService.class);
		try {
			bService.bug();
		} catch (RuntimeException ex) {
			System.out.println("应该有异常：" + ex.getMessage());
		}
	}

}
