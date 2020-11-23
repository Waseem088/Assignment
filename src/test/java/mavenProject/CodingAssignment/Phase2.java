package mavenProject.CodingAssignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Phase2 {
	
	@Test
	   public void getWheatherDetails() {
      
	   //Specify base uri
	   RestAssured.baseURI="http://api.openweathermap.org/data/2.5/";
      
	   //Request object
	   RequestSpecification Request=RestAssured.given();
	   
	   //Response object
	   Response response=Request.queryParam("q","Bengaluru")
               .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").get("/weather");
	   System.out.println(response);
	   
	   //print response in console window
	   String jsonString = response.getBody().asString();
       System.out.println(jsonString);



		
	   

		
	}
}
