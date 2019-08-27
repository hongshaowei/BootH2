package idv.shaowei.BootH2.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;

@Component
public class CentralParamHikariConfig extends HikariConfig implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		super.setDriverClassName("org.h2.Driver");
        super.setJdbcUrl("jdbc:h2:mem:testdb");
        super.setUsername("sa");
        super.setPassword("");
	}
}
