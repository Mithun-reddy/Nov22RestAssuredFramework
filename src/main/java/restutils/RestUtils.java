package restutils;

import java.util.HashMap;

import org.hamcrest.Matcher;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {

	public static Response taPost(HashMap<String, String> headers, HashMap<String, String> payload, String pathParam) {

		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		Response res = RestAssured.given().when().headers(headers).body(payload).post(pathParam);
//				then().assertThat()
//				.statusCode(201).extract().response();
		return res;
	}
	
	public static Response taGet(HashMap<String, String> headers, String pathParam) {

		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		Response res = RestAssured.given().when().headers(headers).get(pathParam);
		
//		String res1 = RestAssured.given().when().headers(headers).get(pathParam).asPrettyString();

		return res;
	}

}
