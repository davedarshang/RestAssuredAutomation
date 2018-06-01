package API.RestAPIAutomation.tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RequestData {

	// Example of query parameter
	//@Test
	public void testQueryParam(){
		
		given().
	    	contentType(ContentType.JSON).
			queryParam("id","1").
			//queryParam("","").
		when().
			get("http://localhost:3001/posts").
		then().
			statusCode(200).
			log().all();
	}
	
	//Example of post method using form parameter
	
	@Test
	public void testFormParam(){
		
		
		RestAssured.baseURI ="http://localhost:3001";
		RequestSpecification request = RestAssured.given();
		
		// JSONObject is a class that represents a simple
		// JSON. We can add Key - Value pairs using the put
		// method
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 9); // Cast
		requestParams.put("title", "Test title using Request Specification object.");		 
		requestParams.put("author", "RestAssured Framework.");
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		 
		// Post the request and check the response
		Response response = request.post("/posts");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
		//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		
		/*
		given().
    		//contentType(ContentType.JSON).			
			//formParam("id",7).
			//formParam("title","Test title using Form Parameter.").
			//formParam("author","RestAssured Framework.").
//			param("id",7).
//			param("title","Test title using Form Parameter.").
//			param("author","RestAssured Framework.").
			log().all().
		//queryParam("","").
		when().
			request.post("/posts").
		then().
			statusCode(201).
			log().all();*/
	}
}
