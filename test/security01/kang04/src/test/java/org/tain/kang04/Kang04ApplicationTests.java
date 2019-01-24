package org.tain.kang04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tain.kang04.domain.FruitProperty;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Kang04ApplicationTests {

	@Value("${property.test.name}")
	private String propertyTestName;
	
	@Value("${propertyTest}")
	private String propertyTest;
	
	@Value("${noKey:default value}")
	private String defaultValue;
	
	@Value("${propertyTestList}")
	private String[] propertyTestArray;
	
	@Value("#{'${propertyTestList}'.split(',')}")
	private List<String> propertyTestList;
	
	@Value("${org.tain.server.port}")
	private String orgTainServerPort;
	
	@Value("${server.port}")
	private String serverPort;

	@Test
	public void contextLoads() {
		// if you can do, let you to solve.
		//assertThat(serverPort, is("8000"));
		
		assertThat(orgTainServerPort, is ("8000"));
	}

	@Test
	public void testValue() {
		assertThat(propertyTestName, is("property depth test"));
		assertThat(propertyTest, is("test"));
		assertThat(defaultValue, is("default value"));
		
		// Array
		assertThat(propertyTestArray[0], is("a"));
		assertThat(propertyTestArray[1], is("b"));
		assertThat(propertyTestArray[2], is("c"));
		
		// List
		assertThat(propertyTestList.get(0), is("a"));
		assertThat(propertyTestList.get(1), is("b"));
		assertThat(propertyTestList.get(2), is("c"));
	}
	
	@Autowired
	private FruitProperty fruitProperty;
	
	@Test
	public void testConfigurationProperties() {
		String title = this.fruitProperty.getTitle();
		List<Map<String, String>> list = this.fruitProperty.getList();
		List<String> arr = this.fruitProperty.getArr();
		
		assertThat(title, is("Fruit Title"));
		
		assertThat(list.get(0).get("name"), is("banana"));
		assertThat(list.get(0).get("color"), is("yellow"));
		
		assertThat(list.get(1).get("name"), is("apple"));
		assertThat(list.get(1).get("color"), is("red"));
		
		assertThat(list.get(2).get("name"), is("water melon"));
		assertThat(list.get(2).get("color"), is("green"));
		
		assertThat(arr.get(0), is("Hello"));
	    assertThat(arr.get(1), is("World"));
	    assertThat(arr.get(2), is("Seok"));
	}
}

