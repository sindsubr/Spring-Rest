package org.sindu.restapi.databinding.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.sindu.restapi.databinding")
@EnableWebMvc
public class DemoSpringRestConfig {

}
