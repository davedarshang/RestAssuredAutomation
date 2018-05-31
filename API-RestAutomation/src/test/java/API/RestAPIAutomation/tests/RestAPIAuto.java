package API.RestAPIAutomation.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RestAPIAuto {

	//@Test
	public void testStatusCode(){
		given().
			get("https://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void verifycontentType(){
		given().
			get("https://jsonplaceholder.typicode.com/posts/3").
		then().
			//statusCode(200).
			contentType(ContentType.JSON).
			log().all();
	}
	
	
	//@Test
	public void verifyGroovyCommand_BDD(){
		given().
			get("https://jsonplaceholder.typicode.com/posts").
		then().
			//statusCode(200).
			//sertThat().body()
			//contentType(ContentType.JSON).
			//body("id",hasItems("55","54")).
			log().all();
	}
	
	
}
