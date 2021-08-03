package endpoints;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HealthCheck {

	@Test
	public void check_status() {
		RestAssured.given().log().all().
		when().get("http://localhost:3001/ping").
		then().log().body().assertThat().statusCode(201);
	}
}
