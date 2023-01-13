package restutils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import io.restassured.response.Response;

public class Utils {
	
	
	
	public static String readFileToString(String filePath) throws IOException {
		byte[] json = Files.readAllBytes(Paths.get(filePath));
		
		return new String(json, StandardCharsets.UTF_8);
	}
	
	public static String generateToken() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> loginAccount = new HashMap<String, String>();
		loginAccount.put("username", "mithun@ta.com");
		loginAccount.put("password", "mithun");
		
		String path = "/login";
		
		Response res = RestUtils.taPost(headers, loginAccount, path);
		
//		Response res = RestAssured.given().when().header("Content-Type","application/json")
//				.body(loginAccount).post("/login")
//				.then().assertThat().statusCode(201).extract().response();
//		System.out.println(res.asPrettyString());
		String loginToken = res.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(loginToken);
		return loginToken;
	}

}
