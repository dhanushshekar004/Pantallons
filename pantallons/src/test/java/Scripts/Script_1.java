package Scripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonNode;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import base.Required_Data;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;

public class Script_1 extends Required_Data{
	
	
	
@Test
public void fghj()
{
	RestAssured.baseURI=URL;
	long a=50;
	Response response = RestAssured.given()
			.header("sessionId", "algtestsession004851311971")
			.header("capillaryUserId", "algtestuser236286206191")
			.header("shopid", shopId)
			.header("devicetype", "app")
			.header("regionId","KA")
			.queryParam("placements", "home_page.herobanner_1,home_page.herobanner_2,home_page.shopbycat_1")
			.queryParam("rcs", "eF5j4cotK8lMETC0NLPUNdQ1ZClN9khOTk0yNDM20k01TjTWNTEwNtBNSbIw0TVNMjM0NkkytzCxSAIAmEoOMg")
			.queryParam("excludeHtml", "true")
			.pathParam("assets", "assets")
			
			.when()
			.get("{assets}/hp");
	response.then().log().all()
	.and()
	.assertThat().statusCode(200)
	.and()
	
	.assertThat().time(Matchers.lessThan(a), TimeUnit.SECONDS);	
	
//	String str="result";
	
	
	
	
	/*
	 * ArrayList<Object> ddd = response.jsonPath().get("results"); for (int i = 0; i
	 * < ddd.size(); i++) { System.out.println(ddd.get(i));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
	
}


