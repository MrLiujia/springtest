package springtest.di.ioc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("springtest/di/ioc/xml/beans.xml"); // 创建组件容器
		A a = context.getBean(A.class); // 问容器要感兴趣的组件
		a.a();
		
		A a2 = context.getBean(A.class);
		System.out.println("a和a2是同一个吗？" + (a == a2));
		// true说明默认情况下(singleton)，spring会缓存创建好的组件，再一次获取得到的是同一个
		
		D d = context.getBean(D.class);
		D d2 = context.getBean(D.class);
		System.out.println("d和d2是同一个吗？" + (d == d2));
		// false，组件d被配置为scope=prototype，每次获取都会新创建一个
		
		// 当容器中有多个实现了指定接口的组件时，spring会报错，除非提供更多信息(如@Primary)帮助spring选择
		ShortMessageService sms = context.getBean(ShortMessageService.class);
		sms.send("13312345678", "中奖了");
	}

}
