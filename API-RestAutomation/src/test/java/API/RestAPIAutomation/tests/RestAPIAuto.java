package API.RestAPIAutomation.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.*;

import java.util.List;
import java.util.Map;

public class RestAPIAuto {

	//@Test
	public void testStatusCode(){
		given().
			get("https://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
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
	
	// Test using json path object
	//@Test
	public void testJsonPath(){
		
		String jsonString=
				when().
					get("https://jsonplaceholder.typicode.com/posts").
				then().
				extract().asString();
		
		List<Integer> albumids= from(jsonString).get("id");
		System.out.println(albumids.size());
	}
	
	// Test using json path object
	//@Test
	public void testJsonPath1(){
			
		String jsonString=
			when().
				get("https://jsonplaceholder.typicode.com/posts").
			then().
			extract().asString();
		
		JsonPath jsonPath=new JsonPath(jsonString);
		
		List<Integer> albumids= jsonPath.get("title");
		System.out.println(albumids.size());
	}
		
	// Example of Cookies and Headers
	@Test
	public void testHeaders(){
		
		Response res=get("https://jsonplaceholder.typicode.com/posts");
		
		// to get Sting header- Particular key
		
		String headerCFRAY=res.getHeader("CF-RAY");
		System.out.println(">>>>>>> Header Key = CF-RAY : "+headerCFRAY);
		
		// to get all keys in header
		
		Headers header=res.getHeaders();
		for(Header h:header){
			System.out.println(h.getName()+" : "+h.getValue());
		}
	}
	
	// Example of Cookies
	@Test
	public void testCookies(){
		
		Response res=get("https://jsonplaceholder.typicode.com/posts");
		
		Map<String,String> cok=res.getCookies();
		
		for(Map.Entry<String, String> en:cok.entrySet()){
			System.out.println(en.getKey()+" : "+en.getValue());
		}
	}
	
	// to get details of cookies
	
	@Test
	public void testCookiesDetails(){
		
		Response res=get("https://jsonplaceholder.typicode.com/posts");
		
		Cookie a = res.getDetailedCookie("__cfduid");
		System.out.println("Detailed : "+a.hasExpiryDate());
		System.out.println("Detailed : "+a.getExpiryDate());
		System.out.println("Detailed : "+a.hasValue());
		
	}
}









