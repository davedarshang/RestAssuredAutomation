package API.RestAPIAutomation.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAPIAuto {

	@Test
	public void testStatusCode(){
		given().
			get("https://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200).
			log().all();
	}
}
