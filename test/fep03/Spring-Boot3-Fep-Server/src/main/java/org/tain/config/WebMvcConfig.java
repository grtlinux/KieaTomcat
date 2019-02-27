package org.tain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.tain.utils.ClassUtil;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private static final boolean flag = true;

	public WebMvcConfig() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/index").setViewName("home");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/hello").setViewName("hello");
	}
}
