package org.sindu.restapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringRestSecurityCustomerConfiguration {

	@Autowired
	private DataSource myDataSource;

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(myDataSource);
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/customers").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.GET, "/api/customers/**").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER","ADMIN")
		.antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER","ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/customers/").hasAnyRole("MANAGER","ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER","ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/customers/**").hasAnyRole("MANAGER","ADMIN")
		.and().httpBasic().and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
	
}
