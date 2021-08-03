package endpoints;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Authorization {

	public static String auth_token ;

	
	@Test
	public void authorize_client() {
		File auth = new File("D:\\learning\\Software_Testing\\Automation\\workspace\\Restful.booker\\src\\test\\resources\\Auth");
		JsonPath responce = RestAssured.given().contentType(ContentType.JSON).body(auth).log().all().
		when().post("http://localhost:3001/auth").
		then().assertThat().statusCode(200).log().all().extract().jsonPath();
		
		auth_token = responce.getString("token") ;
		System.out.println(auth_token);
	}
}
