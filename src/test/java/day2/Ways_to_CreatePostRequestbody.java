package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Ways_to_CreatePostRequestbody {
	
	//1) post request body by using Hashmap
	
	int id;
	
//	@Test(priority = 1)
	public void createUser()
	{
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "joe root");
		data.put("job", "crickter");
		
		given()
		  .contentType("application/json")
		  .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		
		.then()
		 .statusCode(201)
		 .body("name", equalTo("joe root"))
		 .log().all();
	}
	

	
	
	//2) post request body by using org.json library
//	@Test
	public void createUserbyjsonlibrary()
	{
		JSONObject data = new JSONObject();
		data.put("name", "joga");
		data.put("job", "software engineer");
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		
		.when()
		  .post("https://reqres.in/api/users")
		 
		
		.then()
		 .statusCode(201)
		 .body("name", equalTo("joga"))
		 .body("job", equalTo("software engineer"))
		 .log().all();
	}
	
	
	//3) post request body by using POJO
//	@Test
	public void createUserbyPOJO()
	{
		Pojo_PostRequest data = new Pojo_PostRequest();
		data.setName("pradeep");
		data.setJob("tutor");
		given()
		  .contentType("application/json")
		  .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		 
		
		.then()
		 .statusCode(201)
		 .body("name", equalTo("pradeep"))
		 .body("job", equalTo("tutor"))
		 .log().all();
	}
	
	//4) post request body by using external json file
	
	@Test
	void createUserbyexternalJson() throws FileNotFoundException
	{

	//	File data = new File(".\\src\\test\\resources\\data.json");
		
		File f = new File(".\\src\\test\\resources\\data.json");
		java.io.FileReader fr = new java.io.FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		
		.when()
		  .post("https://reqres.in/api/users")
		 
		.then()
		 .statusCode(201)
		 .body("name", equalTo("joga rao"))
		 .body("job", equalTo("automation test engineer"))
		 .log().all();
	}
	

}
