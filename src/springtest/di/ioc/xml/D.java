package springtest.di.ioc.xml;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class D {
	public void d() {
		System.out.println("d");
	}
}
