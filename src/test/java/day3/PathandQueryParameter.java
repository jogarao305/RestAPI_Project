package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathandQueryParameter {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryandpathParameter()
	{
		given()
		  .pathParam("mypath", "users")  //path parameter
		  .queryParam("page", "2")      //Query parameter
		  .queryParam("id", "5")        //Query parameter
		  
		.when()
		  .get("https://reqres.in/api/{mypath}")
		  
		.then()
		 .statusCode(200)
		 .log().all();
	}

}
