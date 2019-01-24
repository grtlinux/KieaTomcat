package org.tain.kang06;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tain.kang06.properties.Fruit;
import org.tain.kang06.properties.Property;
import org.tain.kang06.properties.Server;
import org.tain.kang06.properties.Thomson;
import org.tain.kang06.properties.Udp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTests {

	@Autowired
	private Property property;
	
	@Autowired
	private Server server;
	
	@Autowired
	private Fruit fruit;
	
	@Autowired
	private Thomson thomson;
	
	@Test
	public void test_Property() {
		assertThat(this.property.getPropertyTestName(), is("property depth test"));
		assertThat(this.property.getPropetyTest(), is("test"));
		assertThat(this.property.getDefaultValue(), is("default value"));

		String[] arr = this.property.getArrProperty();
		assertThat(arr[0], is("a"));
		assertThat(arr[1], is("b"));
		assertThat(arr[2], is("c"));
		
		List<String> list = this.property.getListProperty();
		assertThat(list.get(0), is("a"));
		assertThat(list.get(1), is("b"));
		assertThat(list.get(2), is("c"));
	}
	
	@Test
	public void test_Server() {
		assertThat(this.server.getName(), is("Spring Boot Web Listen Port"));
		//assertThat(this.server.getPort(), is(8888)); // error : >>>>> server = Server(port=-1)
	}
	
	@Test
	public void test_Fruit() {
		assertThat(this.fruit.getTitle(), is("Fruit Title"));
		assertThat(this.fruit.getCount(), is(12345));
		
		List<Map<String, Object>> list = this.fruit.getList();
		assertThat(list.get(0).get("name"), is("banana"));
		assertThat(list.get(0).get("color"), is("yellow"));
		assertThat(list.get(0).get("price"), is(1000));
		
		List<String> country = this.fruit.getCountry();
		assertThat(country.get(0), is("Korea"));
	}

	@Test
	public void test_Thomson() {
		assertThat(this.thomson.getName(), is("Kiea Thomson"));
		assertThat(this.thomson.getUdpIp(), is("192.168.1.123"));
		assertThat(this.thomson.getUdpPort(), is(1024));
		assertThat(this.thomson.getListenPort(), is(3306));
		
		Udp udp = this.thomson.getUdp();
		assertThat(udp.getIp(), is("192.168.1.123"));
		assertThat(udp.getPort(), is(1024));
	}
}
