Spring-Boot-Jar-ClassPathResource
=================================


```

- SpringBoot resources files managing
	site: https://stackoverflow.com/questions/36371748/spring-boot-access-static-resources-missing-scr-main-resources
    
    
	<Project>/src/main/java
    <Project>/src/main/resources/countries.xml
    
    1. File file = new ClassPathResource("countries.xml").getFile();
    
    2. ClassPathResource classPathResource = new ClassPathResource("fileName");
    	InputStream inputStream = classPathResource.getInputStream();
        content = IOUtils.toString(inputStream);
    
    3. Resource resource = new ClassPathResource("countries.xml");
    	File file = resource.getFile();
    
    4. InputStream inputStream = getClass().getResourceAsStream("/yourFile");
    
    5. File file = ResourceUtils.getFile("classpath:myFile.xml");
    

	site: [Access a File from the Classpath in a Spring Application](https://www.baeldung.com/spring-classpath-file-access "")


	중요-site: [Spring Boot Executable jar에서 file resource 처리](https://sonegy.wordpress.com/2015/07/23/spring-boot-executable-jar%EC%97%90%EC%84%9C-file-resource-%EC%B2%98%EB%A6%AC/ "")

	중요-중요-sitr: [spring-boot spring boot - jar로 실행할 때 클래스 경로 자원을 찾을 수 없습니다.](https://code.i-harness.com/ko-kr/q/18abc74 "")


```

- Eclipse에서 실행해 확인하고 Executable Jar 을 생성하고 실행해서 확인한다.

```

--------------------------------------------------------------
// FileNotFoundException ERROR
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(Application.class);

    @Value("${message.file}")
    private Resource messageResource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        // both of these work when running as Spring boot app from STS, but
        // fail after mvn package, and then running as java -jar
        testResource(new ClassPathResource("message.txt"));
        testResource(this.messageResource);
    }

    private void testResource(Resource resource) {
        try {
            resource.getFile();
            logger.debug("Found the resource " + resource.getFilename());
        } catch (IOException ex) {
            logger.error(ex.toString());
        }
    }
}
--------------------------------------------------------------
String data = "";
ClassPathResource cpr = new ClassPathResource("static/file.txt");
try {
    byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
    data = new String(bdata, StandardCharsets.UTF_8);
} catch (IOException e) {
    LOG.warn("IOException", e);
}
--------------------------------------------------------------
Resource resource = new ClassPathResource("data.sql");
BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
reader.lines().forEach(System.out::println);
--------------------------------------------------------------
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

public final class ClassPathResourceReader {

    private final String path;

    private String content;

    public ClassPathResourceReader(String path) {
        this.path = path;
    }

    public String getContent() {
        if (content == null) {
            try {
                ClassPathResource resource = new ClassPathResource(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                content = reader.lines().collect(Collectors.joining("\n"));
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return content;
    }
}
--------------------------------------------------------------
String content = new ClassPathResourceReader("data.sql").getContent();
--------------------------------------------------------------
to get list of data from src/main/resources/data folder --
first of all mention your folder location in properties file as - 
resourceLoader.file.location=data

inside class declare your location. 

@Value("${resourceLoader.file.location}")
    @Setter
    private String location;

    private final ResourceLoader resourceLoader;

public void readallfilesfromresources() {
       Resource[] resources;

        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:" + location + "/*.json");
            for (int i = 0; i < resources.length; i++) {
                try {
                InputStream is = resources[i].getInputStream();
                byte[] encoded = IOUtils.toByteArray(is);
                String content = new String(encoded, Charset.forName("UTF-8"));
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
}
--------------------------------------------------------------


```




References
----------
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):



.....
