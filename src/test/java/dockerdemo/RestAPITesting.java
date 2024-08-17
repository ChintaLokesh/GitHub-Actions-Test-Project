package dockerdemo;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pojoclasses.Welcome4;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPITesting {
	
	String id;
	@Test(priority = 0)
	public void testGETAPI() throws JsonMappingException, JsonProcessingException
	{
		// object ff8081819159cae601915b07ea9302dd
		RestAssured.baseURI="https://api.restful-api.dev/";
		RequestSpecification spec=RestAssured.given();
		spec.log().all();
		Response res=spec.get("/objects");
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Get API response code  is:"+res.getStatusCode());
		System.out.println("Get API response code  is:"+res.getBody().asString());
		
		
		// JsonAnnotation doesnt work with Gson
		// Instead use object mapper
		
		System.out.println("-------------using GSON ---------------------");
		Welcome4[] welcome4=new Gson().fromJson(res.getBody().asString(), Welcome4[].class);
		
		List<Welcome4> list=Arrays.asList(welcome4);
		
		System.out.println("size of the list:"+list.size());
		
		list.stream().filter(e -> e.getData() != null)
		.forEach( e -> System.out.println(e.getID() +"| "+e.getName()
		+"| "+ e.getData().getColor() +"| "+e.getData().getCapacity() +"| "+e.getData().getCPUModel()
		+"| "+ e.getData().getHardDiskSize() +"| "+e.getData().getGeneration()
		+"| "+e.getData().getStrapColour() +"| "+e.getData().getCaseSize()
		+"| "+e.getData().getCapacityGB()));
		
		System.out.println("--------------------------------------------");
		System.out.println("--------------using object mapper-----------------");

		
		ObjectMapper mapper = new ObjectMapper();
		Welcome4[] welcome5=mapper.readValue(res.getBody().asString(), Welcome4[].class);
		
		List<Welcome4> list1=Arrays.asList(welcome5);
		
		System.out.println("size of the list:"+list1.size());
		
		list1.stream().filter(e -> e.getData() != null)
		.forEach( e -> System.out.println(e.getID() +"| "+e.getName()
		+"| "+ e.getData().getColor() +"| "+e.getData().getCapacity()
		+"| "+e.getData().getCapacityGB() +"| "+e.getData().getPrice()
		+"| "+e.getData().getGeneration() +"| "+e.getData().getYear()
		+"| "+e.getData().getCPUModel()   +"| "+e.getData().getHardDiskSize()
		+"| "+e.getData().getStrapColour()
		+"| "+e.getData().getCaseSize()   +"| "+e.getData().getDescription()
		+"| "+e.getData().getScreenSize() +"| "+e.getData().getCapacity1()
		+"| "+e.getData().getPrice1()     +"| "+e.getData().getGeneration1()));
		
		
//		System.out.println("GET Id Is:"+ list.get(0).getID());
//		System.out.println("GET Name Is:"+ list.get(0).getName());
//		System.out.println("GET color Is:"+ list.get(0).getData().getColor());
//		System.out.println("GET Capacity Is:"+ list.get(0).getData().getCapacity());
//		System.out.println("GET price Is:"+ list.get(0).getData().getPrice());
	}

	
	@Test(priority = 1)
	public void testPostAPI()
	{
		String body ="{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 3024,\r\n"
				+ "      \"price\": 2849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}";
		RestAssured.baseURI="https://api.restful-api.dev/";
		
		RequestSpecification spec=RestAssured.given();
		spec.contentType("application/json");
		spec.body(body);
		spec.log().all();
		Response res=spec.post("/objects");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("POST API response code  is:"+res.getStatusCode());
		System.out.println("POST API response code  is:"+res.getBody().asString());
		
		JsonPath jp = new JsonPath(res.getBody().asString());
		id=jp.get("id").toString();
		System.out.println("created ID :"+id);
		
	}
	
	
	@Test(priority = 2)
	public void testPUTAPI()
	{
		RestAssured.baseURI="https://api.restful-api.dev/";
		RequestSpecification spec=RestAssured.given();
		spec.contentType("application/json");
		
		String body="{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2024,\r\n"
				+ "      \"price\": 2049.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\",\r\n"
				+ "      \"color\": \"silver\"\r\n"
				+ "   }\r\n"
				+ "}";
		spec.body(body);
		spec.log().all();
		System.out.println("INPUT ID :"+id);
		Response res=spec.put("objects/"+id);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("PUT API Response code: "+res.getStatusCode());
		System.out.println("PUT API Response: "+res.getBody().asString());
		
		
	}
	
	@Test(priority = 3)
	public void testPATCHAPI()
	{
//		id="ff808181915b67d301915e69448e03bc";
		RestAssured.baseURI="https://api.restful-api.dev/";
		RequestSpecification spec=RestAssured.given();
		spec.contentType("application/json");
		
		String body="{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\r\n"
				+ "}";
		spec.body(body);
		spec.log().all();
		System.out.println("INPUT ID :"+id);
		Response res=spec.patch("objects/"+id);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("PATCH API Response code: "+res.getStatusCode());
		System.out.println("PATCH API Response: "+res.getBody().asString());
		
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteAPI()
	{
		Response res=null;
		RestAssured.baseURI="https://api.restful-api.dev/";
		
		RequestSpecification spec=RestAssured.given();
		System.out.println("INPUT ID :"+id);
		spec.log().all();
		if( id !=null)
		{
//			res=spec.delete("/objects/ff8081819159cae601915b12fc8e02e9");
		res=spec.delete("/objects/"+id);
		}
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Delete API response code  is:"+res.getStatusCode());
		System.out.println("Delete API response body  is:"+res.getBody().asString());
		
	}
}
