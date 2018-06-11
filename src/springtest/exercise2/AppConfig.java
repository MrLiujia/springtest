package springtest.exercise2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "springtest.exercise2")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		// TODO 连接参数从属性文件中获取
		DriverManagerDataSource ds = new DriverManagerDataSource(
				"jdbc:h2:tcp://localhost/D:/zhujunqi/h2db/h2db-8",
				"sa",
				"123456");
		ds.setDriverClassName("org.h2.Driver");
		return ds;
	}
}
