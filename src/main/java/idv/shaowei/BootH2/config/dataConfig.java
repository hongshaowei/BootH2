package idv.shaowei.BootH2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= {"idv.shaowei.BootH2"})
public class dataConfig {
	@Autowired
	private ApplicationContext context;

	@Bean
	public HikariDataSource dataSource() {
		HikariDataSource ds = new HikariDataSource((HikariConfig) context.getBean("centralParamHikariConfig"));
		return ds;
	}
	
	@Bean
	@DependsOn("dataSource")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource((DataSource) context.getBean("dataSource"));
		return jdbcTemplate;
	}
	
	@Bean
	@DependsOn("dataSource")
	public DataSourceTransactionManager tranactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource((DataSource) context.getBean("dataSource"));
		return txManager;
	}
	
}
