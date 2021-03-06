package org.tain.kang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/index").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout()
				//.permitAll()
				.logoutSuccessUrl("/").permitAll();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		
		UserDetails user = userBuilder
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		
		UserDetails admin = userBuilder
				.username("admin")
				.password("password")
				.roles("USER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
