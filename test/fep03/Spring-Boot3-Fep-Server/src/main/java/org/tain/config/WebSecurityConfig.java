package org.tain.config;

import org.springframework.context.annotation.Configuration;
import org.tain.utils.ClassUtil;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final boolean flag = true;
	
	public WebSecurityConfig() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/", "/home", "/index").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login").permitAll()
//				.and()
//			.logout()
//				.logoutSuccessUrl("/").permitAll();
//	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		@SuppressWarnings("deprecation")
//		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//		
//		List<UserDetails> list = new ArrayList<>();
//		list.add(userBuilder.username("admin").password("kang123").roles("ADMIN").build());
//		list.add(userBuilder.username("user").password("kang123").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(list);
//	}
}
