package org.tain.kang05;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
		//value = "value=test",
		properties = { "value=test", "property.value=propertyTest" },
		classes = { Kang05Application.class },
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
		)
public class SpringBootTestTests {

	@Value("${value}")
	private String value;
	
	@Value("${property.value}")
	private String propertyValue;
	
	@Test
	public void contextLoads() {
		assertThat(value, is("test"));
		assertThat(propertyValue, is("propertyTest"));
	}
}
