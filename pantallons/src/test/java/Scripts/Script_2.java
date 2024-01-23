package Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.Required_Data;
import cucumber.api.cli.Main;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Script_2 extends Required_Data {
	
	

	@Test
	public void getDeviceName(ITestContext val) throws FileNotFoundException, IOException  {
		RestAssured.baseURI=URL;
		Response response = RestAssured.given()
				.header("shopid",shopId )
				.header("deviceid", deviceId )
				.header("devicetype",deviceType)
				.header("hash",hash)
				.header("pagetype","profile")
				.pathParam("user", "user")
				.pathParam("device", "device")
				.body("{\r\n"
						+ "    \"isVisualSearch\": 0,\r\n"
						+ "    \"geoLocation\": {\r\n"
						+ "        \"latitude\": 343\r\n"
						+ "    },\r\n"
						+ "    \"fcmToken\":\"asdfasda\",\r\n"
						+ "    \"version\" : 1.2,\r\n"
						+ "    \"validateHash\": false\r\n"
						+ "}")	
				.when()
				.post("/{user}/{device}");
	String time = response.header("Expires");
	System.out.println("dfg"+time);
	
		response.then().log().all()
		.and()
		.assertThat().statusCode(200)
		
		.and()
		.assertThat().contentType(ContentType.JSON)
		.and()		
	
				
			.assertThat().time(Matchers.lessThan(a), TimeUnit.SECONDS);
		Object token = response.jsonPath().get("results.deviceToken");
		Object statsu = response.jsonPath().get("results.expressDelivery");
			String deviceToken = token.toString();
		sett(deviceToken);
		Assert.assertEquals(trueflag, statsu);
					System.out.println(token);
					System.out.println("ghjjjj"+time);
		System.out.println(statsu);
		System.out.println("fghj");

	//	System.out.println(Required_Data.dateAndTime());
	
		
		System.out.println("fghj");
		
		Required_Data.dateAndTime();
	 Required_Data d= new Required_Data();
	String verifyTIME = d.gmtTime;
	System.out.println("yyyy"+verifyTIME);
	System.out.println("ghjjjj"+time);

	Assert.assertEquals(time, verifyTIME);
	}
	
		
	}


