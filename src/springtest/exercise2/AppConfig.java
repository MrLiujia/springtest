package springtest.exercise2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "springtest.exercise2")
@PropertySource({"classpath:jdbc.properties", "classpath:springtest/exercise2/app.properties"}) // 注册属性文件到配置环境 Environment
public class AppConfig {

	@Bean // 通过参数列表声明依赖，类似于构造器注入，实际上，@Bean方法的角色也是工厂方法
	public DataSource dataSource(Environment env) { // 数据源依赖配置环境
		DriverManagerDataSource ds = new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) { // JDBC模板依赖数据源
		return new JdbcTemplate(ds);
	}
}
