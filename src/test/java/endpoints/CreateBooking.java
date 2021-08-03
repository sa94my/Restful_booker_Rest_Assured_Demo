package endpoints;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBooking {

	@Test
	public void create_booking() {
		File postBody = new File("D:\\learning\\Software_Testing\\Automation\\workspace\\Restful.booker\\src\\test\\resources\\create_booking");
		RestAssured.given().contentType(ContentType.JSON).body(postBody).log().all().
		when().post("http://localhost:3001/booking").
		then().assertThat().statusCode(200).log().all();
	}
}
