package day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTP_requestspractise {
	
	@Test(priority = 1)
	void createUser()
	{
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("id", 12);
		data.put("petid", 7);
		data.put("quantity", 10);
		
		given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		 .post("https://petstore.swagger.io/v2/store/order")
		
		.then()
		 .statusCode(200)
		 .log().all();
	}
	
	@Test(priority = 2)
	void getUser()
	{
		
		when()
		 .get("https://petstore.swagger.io/v2/store/order/12")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	void deleteUser()
	{	
		when()
		 .delete("https://petstore.swagger.io/v2/store/order/12")
		
		.then()
		  .statusCode(404)
		  .log().all();
	}

}
