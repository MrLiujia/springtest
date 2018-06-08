package springtest.di.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 声明这是配置类
@ComponentScan(basePackages = "springtest.di.ioc.annotation")
public class AppConfig {

	@Bean // 相当于xml中的<bean>
	// 注意：返回类型接口优先，好处就是没有耦合到某种实现、便于替换实现
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13);
	}
}
