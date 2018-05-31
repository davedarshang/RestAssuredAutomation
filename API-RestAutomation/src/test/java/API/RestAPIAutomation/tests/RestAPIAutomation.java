package API.RestAPIAutomation.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIAutomation {

	
	public Response getHttpReuestResponse(RequestSpecification rs,String s)
	{
		return rs.get(s);
	}
	
    //@BeforeClass
    /*public static void setupRestAssured() {
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "/v1/";
        RequestSpecification requestSpecification = new RequestSpecBuilder().
                addHeader("X-Auth-Token", "fze4b032141e23f453c22dbb2f78946b").
                addHeader("X-Response-Control", "minified")
                .build();
        RestAssured.requestSpecification = requestSpecification;
    }*/
    
	//@Test
	public void VerifyStatusCode200()
	{
		RestAssured.baseURI = "http://api.football-data.org/v1/teams/66/fixtures";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	//below test case - find the avatar tag value for id =1.
	//@Test
	public void verifyGroovyCommand()
	{
		RestAssured.baseURI = "https://reqres.in/api";   
		Response response = RestAssured.get("/users");
		System.out.println(response.asString());
		String certainPlayer = response.path("data.find { it.id == 1 }.avatar");		
		System.out.println(certainPlayer);
		Assert.assertEquals(certainPlayer,"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
	}
	
	//below test case - find the author name and its length whose id =1.
	@Test
	public void extractSingleValueWithFind_findAPlayerWithACertainJerseyNumber()
	{
		RestAssured.baseURI = "http://localhost:3000/posts";   
		Response response = RestAssured.get();
		System.out.println(response.asString());
		String certainPlayer = response.path("find { it.id == 1}.author");
		int len=response.path("find { it.id == 1}.author.length()");

		System.out.println(len);		
		System.out.println(certainPlayer);
	}

	//@Test
	public void VerifyStatusCode_200()
	{
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification httpRequest = RestAssured.given();
		//Response response = httpRequest.get("/78789798798");
		Response response = httpRequest.get();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	//@Test
	public void VerifyPostEndpointCode_201(){
		
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json=new JSONObject();
		json.put("id", "6");
		json.put("title", "API Automation6");
		json.put("author", "RestAssured6");
		
		request.body(json.toJSONString());
		//Response resp=request.post("http://localhost:3000/posts");
		Response resp=request.post();
		int Statuscode=resp.getStatusCode();
		Assert.assertEquals(Statuscode, 201);
	}
	
	//@Test
	public void VerifyDeleteEndpoint(){
		
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		String Endpoint="_cND51S";
		Response resp=request.delete("/"+Endpoint);
		int Statuscode=resp.getStatusCode();
		Assert.assertEquals(Statuscode, 404);
	}
	
	//@Test
	public void VerifyPutEndpoint(){
		
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		json.put("id", 5);
		json.put("title", "RestAssured API Automation");
		json.put("author", "Rest Assured Using JAVA");
		
		Response resp=request.put("/"+5);
		int Statuscode=resp.getStatusCode();
		Assert.assertEquals(Statuscode, 200);
	}
	
	//@Test
	public void GetWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		//RequestSpecification httpRequest = RestAssured.given();
		Response response = getHttpReuestResponse(RestAssured.given(),"/Hyderabad");
 
		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();
 
		// Assert that correct status code is returned.s
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	
	//@Test
	public void VerifyCityInJsonResponse()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
	 
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
	 
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");
	 
		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);
	 
		// Validate the response
		Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
	}
	
	//@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Viru"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "viruAPIAuto3");
		requestParams.put("Password", "password1");
	 
		requestParams.put("Email",  "viruAPIauto3@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
	 
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		/*String jsonString="{\n"
							+"'\"'SuccessCode'\"': '\"'OPERATION_SUCCESS'\"',\n"
							+"'\"'Message`\"`: `\"`Operation completed successfully`\"`"
							+"}";*/
		//Assert.assertEquals( "Json String", jsonString, response.getBody().asString());
		System.out.println(response.getBody().asString());
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
}
