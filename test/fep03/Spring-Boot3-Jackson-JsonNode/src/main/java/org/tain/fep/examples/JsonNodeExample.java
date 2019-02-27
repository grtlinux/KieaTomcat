package org.tain.fep.examples;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

//@Component(value = "json.JsonNodeExample")
public class JsonNodeExample {

	private static boolean flag = true;

	public JsonNodeExample() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	private ObjectMapper objectMapper = new ObjectMapper();
	private String carJson = ""
			+ "{ \"brand\" : \"Mercedes\", \"doors\" : 5,"
			+ "\"owners\" : [\"John\", \"Jack\", \"Jill\"],"
			+ "\"nestedObject\" : [{ \"field\" : \"value\","
			+ "\"key\" : \"value2\" }, {\"fld\":\"val\"}] }";

	@Bean(value = "json.JsonNodeExample.test01")
	public void test01() {  // SUCCESS
		if (flag) System.out.println(">>>>> test01. " + ClassUtil.getClassInfo());

		try {
			// jsonString -> JsonNode
			JsonNode jsonNode = this.objectMapper.readValue(this.carJson, JsonNode.class);
			if (flag) System.out.println(">>>>> jsonNode: " + jsonNode);

			// JsonNode -> jsonString
			String json = this.objectMapper.writeValueAsString(jsonNode);
			if (flag) System.out.println(">>>>> json: " + json);

			// JsonNode -> jsonPrettyString
			String jsonPretty = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			if (flag) System.out.println(">>>>> jsonPretty: " + jsonPretty);

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (flag) System.out.println("-----------------------------------------------");
	}

	@Bean(value = "json.JsonNodeExample.test02")
	public void test02() {   // FAIL
		if (flag) System.out.println(">>>>> test02. " + ClassUtil.getClassInfo());

		try {
			// jsonString -> JsonNode
			JsonNode jsonNode = this.objectMapper.readValue(this.carJson, JsonNode.class);
			if (flag) System.out.println(">>>>> jsonNode: " + jsonNode);
			if (flag) System.out.println(">>>>> jsonNode.size(): " + jsonNode.size());

			/*
			List<JsonNode> listJsonNode = (List<JsonNode>) ConvertUtil.iterToList(jsonNode.iterator());
			for (JsonNode node : listJsonNode) {
				if (flag) System.out.println(">>>>> node.key: " + node.getName());
			}
			*/
			
			//////////////////////////////////////////////
			
			JsonNode brandNode = jsonNode.get("brand");
			JsonNode doorsNode = jsonNode.get("doors");
			JsonNode ownersNode = jsonNode.get("owners");
			JsonNode nestedObjectNode = jsonNode.get("nestedObject");

			//////////////////////////////////////////////

			String strBrand = brandNode.asText();
			if (flag) System.out.println(">>>>>>>>>> strBrand = " + strBrand);

			Integer nDoors = doorsNode.asInt();
			if (flag) System.out.println(">>>>>>>>>> nDoors = " + nDoors);

			Integer sizeOwners = ownersNode.size();
			if (flag) System.out.println(">>>>>>>>>> sizeOwners = " + sizeOwners);

			Integer sizeNestedObject = nestedObjectNode.size();
			if (flag) System.out.println(">>>>>>>>>> sizeNestedObject = " + sizeNestedObject);

			//////////////////////////////////////////////

			if (flag || jsonNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> jsonNode.size: " + jsonNode.size());
			}
			if (brandNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> brandNode.array: " + brandNode.fields());
			}
			if (doorsNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> doorsNode.array: " + doorsNode.fields());
			}
			if (ownersNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> ownersNode.array: " + ownersNode.fields());

				Iterator<JsonNode> iterNode = ownersNode.iterator();
				while (iterNode.hasNext()) {
					JsonNode node = iterNode.next();
					if (flag) System.out.println(">>>>>>>>>>>>>>> owners node: " + node.asText());
				}
			}
			if (!flag && nestedObjectNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> nestedObjectNode.array: " + nestedObjectNode.fields());
				
				// ERROR
				Iterator<Entry<String, JsonNode>> iterNode = nestedObjectNode.fields();
				while (iterNode.hasNext()) {
					Entry<String, JsonNode> node = iterNode.next();
					if (flag) System.out.printf(">>>>>>>>>>>>>>> nestedObject node: [%s] [%s]%n", node.getKey(), node.getValue());
				}
			}
			if (nestedObjectNode.isArray()) {
				if (flag) System.out.println(">>>>>>>>>> nestedObjectNode.array: " + nestedObjectNode.fields());
				
				// ERROR
				Iterator<JsonNode> iterNode = nestedObjectNode.iterator();
				while (iterNode.hasNext()) {
					JsonNode node = iterNode.next();
					if (flag) System.out.println(">>>>>>>>>>>>>>> node size: " + node.size());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.println("-----------------------------------------------");
	}
	
	@Bean(value = "json.JsonNodeExample.test03")
	public void test03() {    // SUCCESS
		if (flag) System.out.println(">>>>> test03. " + ClassUtil.getClassInfo());
		
		try {
			JsonNode rootNode = this.objectMapper.readTree(this.carJson);
			
			Iterator<Map.Entry<String,JsonNode>> iter = rootNode.fields();
			while (iter.hasNext()) {
				Map.Entry<String, JsonNode> entry = iter.next();
				if (flag) System.out.printf(">>>>> [%s:%s]%n", entry.getKey(), entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.println("-----------------------------------------------");
	}
	
	private String userJson = "" +
			"{" +
			"  \"id\"   : 1," +
			"  \"name\" : {" +
			"    \"first\" : \"Yong\"," +
			"    \"last\" : \"Mook Kim\" " +
			"  }," +
			"  \"contact\" : [" +
			"    { \"type\" : \"phone/home\", \"ref\" : \"111-111-1234\"}," +
			"    { \"type\" : \"phone/work\", \"ref\" : \"222-222-2222\"}" +
			"  ]" +
			"}";
	@Bean(value = "json.JsonNodeExample.test04")
	public void test04() {
		if (flag) System.out.println(">>>>> test04. TreeModel Traversing " + ClassUtil.getClassInfo());
		
		try {
			// JsonNode rootNode = this.objectMapper.readTree(new File("c:\\user.json"));
			JsonNode rootNode = this.objectMapper.readTree(this.userJson);

			// Get id
			if (flag) System.out.printf("id: %s%n", rootNode.path("id").asLong());
			
			// Get Name
			JsonNode nameNode = rootNode.path("name");
			if (nameNode.isMissingNode()) {
				// if "name" node is missing
			} else {
				if (flag) System.out.println("first name : " + nameNode.path("first").asText());
				if (flag) System.out.println("middle name : " + nameNode.path("middle").asText()); // missing node, just return empty string
				if (flag) System.out.println("last name : " + nameNode.path("last").asText());
			}
			
			// Get Contact
			JsonNode contactNode = rootNode.path("contact");
			if (contactNode.isArray()) {
				// if this node is array?
				for (JsonNode node : contactNode) {
					if (flag) System.out.println("type : " + node.path("type").asText());
					if (flag) System.out.println("ref : " + node.path("ref").asText());
				}
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.println("-----------------------------------------------");
	}

	private String usersJson = "[" +
			"{" +
			"  \"id\"   : 1," +
			"  \"name\" : {" +
			"    \"first\" : \"Yong\"," +
			"    \"last\" : \"Mook Kim\" " +
			"  }," +
			"  \"contact\" : [" +
			"    { \"type\" : \"phone/home\", \"ref\" : \"111-111-1234\"}," +
			"    { \"type\" : \"phone/work\", \"ref\" : \"222-222-2222\"}" +
			"  ]" +
			"}," +	
			"{" +
			"  \"id\"   : 2," +
			"  \"name\" : {" +
			"    \"first\" : \"Song\"," +
			"    \"last\" : \"Zi Lap\" " +
			"  }," +
			"  \"contact\" : [" +
			"    { \"type\" : \"phone/home\", \"ref\" : \"333-333-3333\"}," +
			"    { \"type\" : \"phone/work\", \"ref\" : \"444-444-4444\"}" +
			"  ]" +
			"}" +
			"]";
	
	@Bean(value = "json.JsonNodeExample.test05")
	public void test05() {
		if (flag) System.out.println(">>>>> test05. TreeModel Array Traversing " + ClassUtil.getClassInfo());
		
		try {
			// JsonNode rootNode = this.objectMapper.readTree(new File("c:\\user.json"));
			JsonNode rootArray = this.objectMapper.readTree(this.usersJson);

			for (JsonNode rootNode : rootArray) {
				// Get id
				if (flag) System.out.printf("id: %s%n", rootNode.path("id").asLong());
				
				// Get Name
				JsonNode nameNode = rootNode.path("name");
				if (nameNode.isMissingNode()) {
					// if "name" node is missing
				} else {
					if (flag) System.out.println("first name : " + nameNode.path("first").asText());
					if (flag) System.out.println("middle name : " + nameNode.path("middle").asText()); // missing node, just return empty string
					if (flag) System.out.println("last name : " + nameNode.path("last").asText());
				}
				
				// Get Contact
				JsonNode contactNode = rootNode.path("contact");
				if (contactNode.isArray()) {
					// if this node is array?
					for (JsonNode node : contactNode) {
						if (flag) System.out.println("type : " + node.path("type").asText());
						if (flag) System.out.println("ref : " + node.path("ref").asText());
					}
				}
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.println("-----------------------------------------------");
	}

	@Bean(value = "json.JsonNodeExample.test06")
	public void test06() {
		if (flag) System.out.println(">>>>> test06. TreeModel CRUD " + ClassUtil.getClassInfo());
		
		try {
			// JsonNode rootNode = this.objectMapper.readTree(new File("c:\\user.json"));
			JsonNode rootNode = this.objectMapper.readTree(this.userJson);

			////////////////////////////////////////////////////
			String resultOriginal = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
			if (flag) System.out.println("Before Update " + resultOriginal);
			
			if (flag) {
				// 1. Update id to 1000
				((ObjectNode) rootNode).put("id", 1000L);
			}
			
			JsonNode nameNode = rootNode.path("name");
			if (flag) {
				// 2. If middle name is empty, update to M
				if ("".equals(nameNode.path("middle").asText())) {
					((ObjectNode) nameNode).put("middle", "M");
				}
			}
			
			if (flag) {
				// 3. Create a new field in nameNode
				((ObjectNode) nameNode).put("nickname", "mkyong");
			}
			
			if (flag) {
				// 4. Remove last field in nameNode
				((ObjectNode) nameNode).remove("last");
			}
			
			if (flag) {
				// 5. Create a new ObjectNode and add to root
				ObjectNode positionNode = this.objectMapper.createObjectNode();
				positionNode.put("name", "Developer");
				positionNode.put("years", 10);
				((ObjectNode) rootNode).set("position", positionNode);
			}
			
			if (flag) {
				// 6. Create a new ArrayNode and add to root
				ArrayNode gamesNode = this.objectMapper.createArrayNode();

				ObjectNode game1 = this.objectMapper.createObjectNode();
				game1.put("name", "Fall Out 4");
				game1.put("price", 49.9);

				ObjectNode game2 = this.objectMapper.createObjectNode();
				game2.put("name", "Dark Soul 3");
				game2.put("price", 59.9);

				gamesNode.add(game1);
				gamesNode.add(game2);
				((ObjectNode) rootNode).set("games", gamesNode);
			}
			
			if (flag) {
				// 7. Append a new Node to ArrayNode
				ObjectNode email = this.objectMapper.createObjectNode();
				email.put("type", "email");
				email.put("ref", "abc@mkyong.com");

				JsonNode contactNode = rootNode.path("contact");
				((ArrayNode) contactNode).add(email);
			}
			
			////////////////////////////////////////////////////
			String resultUpdate = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
			System.out.println("After Update " + resultUpdate);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.println("-----------------------------------------------");
	}
}
