package Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import base.Required_Data;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Scripts_4 extends Required_Data{
	
	@Test
	public  void get_city() throws EncryptedDocumentException, IOException {
		
		RestAssured.baseURI=URL;
		Response response = RestAssured.given()
				.queryParam(fcmToken)
				.queryParam("validateHash", "false")
				.queryParam("isRefresh", "0")
				.header("shopId",shopId)
				.header("deviceID", deviceId)
				.header("devicetype",deviceType)
				.header("devicetoken",deviceToken)
				.header("hash",hash)
				.pathParam("location", "location")
				.pathParam("city","city")
				.when()
				
				.get("{location}/{city}");
		
	
		
		response.then().assertThat().statusCode(200)
		.and()
		.assertThat().time(Matchers.lessThan(a),TimeUnit.SECONDS)
		.and()
		.assertThat().contentType(ContentType.JSON);
	
	//	response.jsonPath().get(excelFilePath);
		String body = response.getBody().asString();
		
		String path="results[*].name";
		List<String> l = JsonPath.read(body, "results[*].name");
		List<String> l1=new ArrayList<>();
		for(String e:l) {
			
			if (e.equalsIgnoreCase("chennai")) {
			
				//break;
				
			}
			else {
				System.out.println(e);
			}
			
		}
		
		l1=addcityName(cityNamecolumanIndex);
		System.out.println(l1);
		
		l.containsAll(l1);

	}
	
	

}
