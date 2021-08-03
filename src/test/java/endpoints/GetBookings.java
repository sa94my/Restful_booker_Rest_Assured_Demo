package endpoints;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetBookings {

	@Test
	public void get_all_bookings_ids() {
		RestAssured.given().
		when().get("http://localhost:3001/booking").
		then().assertThat().statusCode(200);
	}
	
	@Test
	public void get_all_bookings_with_filter() {
		RestAssured.given().queryParam("firstname","Ahmad").queryParam("lastname", "Samy").
		when().get("http://localhost:3001/booking").
		then().assertThat().body(Matchers.containsString("bookingid"));
	}
	
	@Test
	public void get_single_booking() {
		RestAssured.given().
		when().get("http://localhost:3001/booking/10").
		then().assertThat().body("firstname",Matchers.notNullValue()).log().body();
	}
}
