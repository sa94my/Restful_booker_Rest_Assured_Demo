package endpoints;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateBooking {

	@Test
	public void update_Booking() {
		File updateBody = new File("D:\\learning\\Software_Testing\\Automation\\workspace\\Restful.booker\\src\\test\\resources\\update_booking");
		RestAssured.given().header("Cookie","token=cb6b533eb23a85e").contentType(ContentType.JSON).body(updateBody).log().all().
		when().put("http://localhost:3001/booking/14").
		then().assertThat().statusCode(200).log().all();
		
	}
}
