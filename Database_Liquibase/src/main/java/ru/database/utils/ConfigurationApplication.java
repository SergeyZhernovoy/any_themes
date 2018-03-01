package ru.database.utils;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigurationApplication {

	@Value("${classpath:db-migrations/db.changelog-master.xml}")
	private String fileName;

	@Bean
	public SpringLiquibase liquibase(@Qualifier("dataSource") DataSource dataSource){
		SpringLiquibase springLiquibase = new SpringLiquibase();
		springLiquibase.setChangeLog(fileName);
		springLiquibase.setDataSource(dataSource);
		return springLiquibase;
	}
}
