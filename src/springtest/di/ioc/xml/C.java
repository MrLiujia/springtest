package springtest.di.ioc.xml;

import java.util.Date;

public class C {
	public void c() {
		System.out.println("ioc xml c");
		Date now = new Date(); // 不算系统组件，临时对象(用完就丢的那种)
		System.out.println(now);
	}
}
