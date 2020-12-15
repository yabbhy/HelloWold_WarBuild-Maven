package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DemoRestApi {

	@Test
	public void testResponseCode() {
		Response resp = get("http://freegeoip.net/json/yahoo.com");
		int code = resp.getStatusCode();
		String data = resp.asString();
		System.out.println("Data is "+data);
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
		System.out.println("Response time "+resp.getTime());
	}
	
	//effective and better recommended way of doing the above task in RestApi testing
	public void testbody() {
		int code = get("http://freegeoip.net/json/yahoo.com").getStatusCode();
		System.out.println("Status code is "+code);
		Assert.assertEquals(code, 200);
		
	}
}
