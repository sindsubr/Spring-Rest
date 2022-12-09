package org.sindu.restapi.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("org.sindu.restapi")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringRestCustomerConfiguration implements WebMvcConfigurer{

	@Autowired
	Environment env;
	
	Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// define bean for RestTemplate ... this is used to make client REST calls
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	// add resource handler for loading css, images, etc
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }	
    
    
    @Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		logger.info(env.getProperty("jdbc.url"));

		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		myDataSource.setMaxPoolSize(getInt(env.getProperty("connection.pool.maxPoolSize")));
		myDataSource.setMinPoolSize(getInt(env.getProperty("connection.pool.minPoolSize")));
		myDataSource.setMaxIdleTime(getInt(env.getProperty("connection.pool.maxIdleTime")));
		return myDataSource;
	}

	private int getInt(String value) {
		return Integer.parseInt(value);
	}
}