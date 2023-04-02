package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers_Info {

//	@Test
	void testHeaderInfo()
	{
		when()
		.get("https://www.google.com/")
		
		.then()
		 .header("Content-Encoding", "gzip")
		 .and()
		 .header("server", "gws")
		 .and()
		 .header("Content-Type", "text/html;")
		 .log().headers();
		
	}
	
	
	@Test
	void testHeaders()
	{
		Response res=given()
		
		.when()
	       .get("https://www.google.com/");	
		
		
	       //get single header info
//	   String header = res.getHeader("Content_Encoding");
//	   System.out.println(header);
	
		//get all headers info
		Headers headervalues = res.getHeaders();
		
		for(Header hd:headervalues)
		{
			System.out.println(hd.getName()+"---->"+hd.getValue());
		}
	}
}
