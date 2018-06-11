package springtest.exercise4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "springtest.exercise4")
@PropertySource("classpath:springtest/exercise4/server.properties")
public class AppConfig {

}
