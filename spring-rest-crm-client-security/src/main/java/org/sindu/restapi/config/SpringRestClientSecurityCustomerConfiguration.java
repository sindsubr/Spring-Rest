package org.sindu.restapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringRestClientSecurityCustomerConfiguration {

	@Autowired
	private DataSource myDataSource;

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(myDataSource);
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/authenticateTheUser").successForwardUrl("/getUserDetails")
		.permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
		return http.build();
	}
	
}
