package springtest.exercise6;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages = "springtest.exercise6")
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
	@Bean
	public DataSource dataSource(Environment env) { 
		DriverManagerDataSource ds = new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
