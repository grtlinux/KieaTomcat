Spring-Boot3-Jackson-JsonNode
=============================

```
ObjectMapper mapper = new ObjectMapper();
String jsonInString = "{'name' : 'mkyong'}";

//JSON from file to Object
Staff obj = mapper.readValue(new File("c:\\file.json"), Staff.class);

//JSON from URL to Object
Staff obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);

//JSON from String to Object
Staff obj = mapper.readValue(jsonInString, Staff.class);

```

```
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>2.6.3</version>
	</dependency>

$ mvn dependency:tree

	[INFO] com.mkyong:json:jar:0.0.1-SNAPSHOT
	[INFO] +- com.fasterxml.jackson.core:jackson-databind:jar:2.6.3:compile
	[INFO] |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.6.0:compile
	[INFO] |  \- com.fasterxml.jackson.core:jackson-core:jar:2.6.3:compile
	[INFO] \- junit:junit:jar:3.8.1:test

```
- @JsonView

```
package com.mkyong.json;

public class Views {
	public static class Normal{};
	public static class Manager extends Normal{};
}

-----------------
package com.mkyong.json;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;

public class Staff {

	@JsonView(Views.Normal.class)
	private String name;

	@JsonView(Views.Normal.class)
	private int age;

	@JsonView(Views.Normal.class)
	private String position;

	@JsonView(Views.Manager.class)
	private BigDecimal salary;

	@JsonView(Views.Normal.class)
	private List<String> skills;
}
-----------------
package com.mkyong.json;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson2Example {

	public static void main(String[] args) {
		Jackson2Example obj = new Jackson2Example();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		Staff staff = createDummyObject();

		try {

			// Salary will be hidden
			System.out.println("Normal View");
			String normalView = mapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
			System.out.println(normalView);

			String jsonInString = "{\"name\":\"mkyong\",\"age\":33,\"position\":\"Developer\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Staff normalStaff = mapper.readerWithView(Views.Normal.class).forType(Staff.class).readValue(jsonInString);
			System.out.println(normalStaff);

			// Display everything
			System.out.println("\nManager View");
			String managerView = mapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
			System.out.println(managerView);

			Staff managerStaff = mapper.readerWithView(Views.Manager.class).forType(Staff.class).readValue(jsonInString);
			System.out.println(managerStaff);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Staff createDummyObject() {

		Staff staff = new Staff();

		staff.setName("mkyong");
		staff.setAge(33);
		staff.setPosition("Developer");
		staff.setSalary(new BigDecimal("7500"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("python");

		staff.setSkills(skills);

		return staff;
	}
}

-----------------------------------
Normal View
{"name":"mkyong","age":33,"position":"Developer","skills":["java","python"]}
Staff [name=mkyong, age=33, position=Developer, salary=null, skills=[java, python]]

Manager View
{"name":"mkyong","age":33,"position":"Developer","salary":7500,"skills":["java","python"]}
Staff [name=mkyong, age=33, position=Developer, salary=7500, skills=[java, python]]

```

- Misc Examples

```
	String json = "[{\"name\":\"mkyong\"}, {\"name\":\"laplap\"}]";
	List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>(){});

	String json = "{\"name\":\"mkyong\", \"age\":33}";
	Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
```




References
----------
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):



.....

