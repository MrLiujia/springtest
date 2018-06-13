package springtest.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 声明这是配置类
@ComponentScan(basePackages = "springtest.aop")
@EnableAspectJAutoProxy // 带了@Aspect的组件会被处理
public class AppConfig {

}
