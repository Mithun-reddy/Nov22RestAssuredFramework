package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import restutils.RestUtils;
import restutils.Utils;
import testsconstants.Constants;

public class RestAPISession extends TestBase {
	
//	@Test (dataProvider = "")
	public void login() throws IOException {
		
		
		String data = Utils.readFileToString(Constants.ADD_DATA_FILEPATH);
//		String userdata = JsonPath.read(Constants.ADD_DATA_FILEPATH, "$.[0]");
		
		System.out.println(data);
		
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
		loginToken = res.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println(loginToken);
		
		//		HashMap<String, String> headers = new HashMap<String, String>();
//		headers.put("Content-Type", "application/json");
//		headers.put("token", token);
	}
	
//	@Test
	public void getData() {
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", loginToken);
		
		String path = "/getdata";
		
		Response res = RestUtils.taGet(headers, path);
		
		String getdata = res.asString();
		
		String firstObj = JsonPath.read(getdata, "$.[0]");
		File schemaFile = new File("C:\\Users\\user\\eclipse-workspace2\\"
				+ "restassuredframework\\src\\main\\java\\testdata\\loginSchema.json");
//		RestAssured.given().body(JsonSchemaValidator.matchesJsonSchema(schemaFile)).
	}
	
//	@Test
	public void testJsonSchemaLogin() {
		
		File schemaFile = new File("C:\\Users\\user\\eclipse-workspace2\\"
				+ "restassuredframework\\src\\main\\java\\testdata\\loginSchema.json");
		

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		HashMap<String, String> loginAccount = new HashMap<String, String>();
		loginAccount.put("username", "mithun@ta.com");
		loginAccount.put("password", "mithun");
		
//		JsonObject jo = new JsonObject();
//		jo.addProperty("", "");
//		jo.addProperty("", "");
//		
		String path = "/login";
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		
		Response res = RestAssured.given().when().headers(headers).body(loginAccount).post(path)
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile)).and().extract().response();
		
		System.out.println(res.asPrettyString());
		
	}
	
	@Test
	public void addData() throws IOException {
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", Utils.generateToken());
		
		Employee e1 = new Employee("33452244", "4", "6", "123456");
		
		ObjectMapper om = new ObjectMapper();
//		Serialization
		System.out.println(om.writeValueAsString(e1));
		om.writeValue(new File("C:\\Users\\user\\eclipse-workspace2\\"
				+ "restassuredframework\\src\\main\\java\\testdata\\sample.json"), e1);
		
		
//		Deserialization
		Employee e2 = om.readValue(new String(""), Employee.class);
		

		//		HashMap<String, String> payload = new HashMap<String, String>();
//		payload.put("accountno", "4658");
//		payload.put("salary", "4");
//		payload.put("departmentno", "4");
//		payload.put("pincode", "677854");
		
		
//		Response res = RestAssured.given().when().headers(headers).body(e1).post("/addData");
	}

}
