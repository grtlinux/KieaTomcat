KieaTomcat/test/security01/hello-security
=========================================

SpringBoot JSP View 설정하기
----------------------------
```
SpringBoot JSP View 설정하기 by 소소한 윤성탁 2016.05.30 18:45

JSP의 위치 

	src/main/webapp/WEB-INF/jsp

기존 SpringBoot는 src/main/resources/teamplates에 타임리프가 들어가면 간단하게 조회된다.
그렇다면 JSP는 위치가 다른데 어떻게?

1. gradle, maven이면 디펜던시를 추가해야한다.

	gradle의 경우

		compile("javax.servlet:jstl")
		compile("org.apache.tomcat.embed:tomcat-embed-jasper")

		- 필요하다면 버전을 추가한다, 필자의 경우 springboot 플러그인으로 알아서 버전을 찾아준다.

	maven의 경우

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

		- maven도 마찬가지로 버전이 필요하면 추가한다.

2. 자바 설정 혹은 application.properties에 경로를 지정한다.

	자바소스 설정
	
		@Configuration
		public class SpringConfig extends WebMvcConfigurerAdapter {

			@Bean
			public ViewResolver getViewResolver() {
				InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
				viewResolver.setPrefix("/WEB-INF/jsp/");
				viewResolver.setSuffix(".jsp");
				return viewResolver;
			}
		}

	혹은 application.properties

		spring.mvc.view.prefix: /WEB-INF/jsp/
		spring.mvc.view.suffix: .jsp

	참고)

	시작점 코드(com.mysample.root)

		@SpringBootApplication
		public class Application {

			public static void main(String[] args) {
				SpringApplication.run(Application.class, args);
			}
		}

	@SpringBootApplication에는 
	@EnableAutoConfiguration

	@ComponentScan이 포함되어 자동으로 하위  package 경로(com.mysample.root이하)는 자동으로 읽는다.

```




References
----------
- [Spring 4 Tutorial with Examples](https://www.concretepage.com/spring-4/ "Spring 4 Tutorial with Examples"): ConcretePage.com ^^
- [Spring Boot Hello World Example – JSP](https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-jsp/ "Spring Boot Hello World Example – JSP"):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):



.....




