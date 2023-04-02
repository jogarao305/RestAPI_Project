package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {
	
//	@Test
	void testCookies()
	{
		given()
		  
		  .when()
		    .get("https://www.google.com/")
		    
		  .then()
		    .cookie("AEC", "AUEFqZdtsLYx9FIE2fAKMhHblLlSLS7dfzdsQ6dGGRNp5yee1keZPSF_pQ")  //this value will change randomly
		    .log().all();
	}
	
	@Test
	void getCookiesInfo()
	{
		       Response res=  given()
		         
		         .when()
		           .get("https://www.google.com/");
		      
		     //get a single cookie info  
		     //   String cookie_Value=res.getCookie("AEC");
		    //  System.out.println(cookie_Value); 
		           
		   //get all cookies info
		  Map<String, String> cooike_values = res.getCookies();
		//  System.out.println(cooike_values.keySet());
		  
		  for(String key:cooike_values.keySet())
		  {
			 String cookies = res.getCookie(key);
			 
			 System.out.println(key+"    " +cookies);
		  }
   
	}

}
