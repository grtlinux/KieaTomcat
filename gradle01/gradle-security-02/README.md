gradle-security-02
==================

- 2018.12.15: modify these sources using gradle-security-01

- 2018.12.15: has some differences of security between 4.2.1 and 5.0.10

- 2018.12.15: reference spring3-web37

- 2018.12.15: the below
```
	<!-- 검사 URL -->
	<http use-expressions="true">
		<intercept-url pattern="/login/loginForm.do" access="permitAll" />
		<intercept-url pattern="/home.do" access="permitAll" />
		<intercept-url pattern="/admin/**" access="hasRole('ADMIN')" />
		<intercept-url pattern="/**" access="hasAnyRole('USER, ADMIN')" />
        
		<form-login login-page="/login/loginForm.do"
					default-target-url="/home.do"
					authentication-failure-url="/login/loginForm.do?error"
					username-parameter="id"
					password-parameter="password" />
		<logout logout-url="/logout"
					logout-success-url="/home.do" />
		        
		<access-denied-handler error-page="/login/accessDenied.do" />
	</http>
    
	<!--  provider  -->
	<authentication-manager>
		<authentication-provider>
			<user-service>
				<user name="user" password="password" authorities="ROLE_USER" />
				<user name="admin" password="password" authorities="ROLE_ADMIN" />
			</user-service>
		</authentication-provider>
	</authentication-manager>
```

References
----------
- [스프링프레임웍 - Spring Security(2) : 커스텀 로그인 화면 및 권한에 따른 접근 제어](https://offbyone.tistory.com/91 "스프링프레임웍 - Spring Security(2) : 커스텀 로그인 화면 및 권한에 따른 접근 제어"):


..........

