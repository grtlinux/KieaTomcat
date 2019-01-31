package org.tain.yaml01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.yaml01.property.Acme2SecurityProperty;
import org.tain.yaml01.property.AcmeSecurityProperty;
import org.tain.yaml01.property.DbConfigProperty;
import org.tain.yaml01.property.FixturesProperty;
import org.tain.yaml01.property.FixturesProperty2;
import org.tain.yaml01.property.InfoProperty;
import org.tain.yaml01.property.ServersProperty;
import org.tain.yaml01.property.SubAppProperty;
import org.tain.yaml01.property.UdpServersProperty;
import org.tain.yaml01.property.ValueProperty;

@SpringBootApplication
//public class YamlTest01Application {
public class YamlTest01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(YamlTest01Application.class, args);
		// SpringApplication app = new SpringApplication(Demo3Application.class);
		// app.run();
	}
	
	@Autowired
	private ServersProperty serversProperty;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("KANG: >>>>> ServersProperty: " + this.serversProperty);
		
	}
	
	//////////////////////////////////////////////////

	@Autowired
	private FixturesProperty fixturesProperty;
	
	@Bean
	public void testFixturesProperty() {
		System.out.println("KANG: >>>>> FixturesProperty " + this.fixturesProperty.getArticles().size());
		
		for (Map<String, String> map : this.fixturesProperty.getArticles()) {
			System.out.println("KANG: >>>>> FixturesProperty " + map);
		}
	}
	
	//////////////////////////////////////////////////

	@Autowired
	private FixturesProperty2 fixturesProperty2;

	@Bean
	public void testFixturesProperty2() {
		System.out.println("KANG: >>>>> FixturesProperty2 " + this.fixturesProperty2.getArticles().size());
		
		for (FixturesProperty2.Info info : this.fixturesProperty2.getArticles()) {
			System.out.println("KANG: >>>>> FixturesProperty2.Info " + info);
		}
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private InfoProperty infoProperty;
	
	@Bean
	public void testInfoProperty() {
		System.out.println("KANG: >>>>> build : " + this.infoProperty.getBuild());
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private DbConfigProperty dbConfigProperty;
	
	@Bean
	public void testDbConfigProperty() {
		System.out.println("KANG: >>>>> DbConfigProperty.propertyTest: " + this.dbConfigProperty.getPropertyTest());
		System.out.println("KANG: >>>>> DbConfigProperty.needUpdateScheme: " + this.dbConfigProperty.getNeedUpdateScheme());
		System.out.println("KANG: >>>>> DbConfigProperty.dataUpdateType: " + this.dbConfigProperty.getDataUpdateType());
		System.out.println("KANG: >>>>> DbConfigProperty.databases: " + this.dbConfigProperty.getDatabases());
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private ValueProperty valueProperty;
	
	@Bean
	public void testValueProperty() {
		System.out.println("KANG: >>>>> ValueProperty.propertyTestName : " + this.valueProperty.getPropertyTestName());
		System.out.println("KANG: >>>>> ValueProperty.propertyTest : " + this.valueProperty.getPropertyTest());
		System.out.println("KANG: >>>>> ValueProperty.defaultValue : " + this.valueProperty.getDefaultValue());
		System.out.println("KANG: >>>>> ValueProperty.propertyTestList : " + this.valueProperty.getPropertyTestList());
		
		System.out.println("KANG: >>>>> ValueProperty.propertyTestArray : " + this.valueProperty.getPropertyTestArray());
		System.out.println("KANG: >>>>> ValueProperty.propertyTestArray : " + new ArrayList<>(Arrays.asList(this.valueProperty.getPropertyTestArray())));
		// System.out.println("KANG: >>>>> ValueProperty.propertyTestArray : " + this.yamlProperties.getPropertyTestArray());
		//for (String str : this.valueProperty.getPropertyTestArray()) {
		//	System.out.println("KANG: >>>>> ValueProperty.propertyTestArray : " + str);
		//}
	}

	//////////////////////////////////////////////////
	
	@Autowired
	private SubAppProperty subAppProperty;
	
	@Bean
	public void testSubAppProperty() {
		System.out.println("KANG: >>>>> SubAppProperty.threadPool = " + this.subAppProperty.getThreadPool());
		System.out.println("KANG: >>>>> SubAppProperty.email = " + this.subAppProperty.getEmail());
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private AcmeSecurityProperty acmeSecurityProperty;
	
	@Bean
	public void testAcmeSecurityProperty() {
		System.out.println("KANG: >>>>> AcmeSecurityProperty: " + this.acmeSecurityProperty);
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private Acme2SecurityProperty acme2SecurityProperty;
	
	@Bean
	public void testAcme2SecurityProperty() {
		System.out.println("KANG: >>>>> Acme2SecurityProperty: " + this.acme2SecurityProperty);
	}
	
	//////////////////////////////////////////////////
	
	@Autowired
	private UdpServersProperty udpServersProperty;
	
	@Bean
	public void testUdpServersProperty() {
		System.out.println("KANG: >>>>> UdpServersProperty: " + this.udpServersProperty);
		
		List<String> list = this.udpServersProperty.getList();
		for (String udpInfo : list) {
			System.out.println("KANG: >>>>> UdpServersProperty.udpInfo: " + udpInfo);
		}
	}
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

}

