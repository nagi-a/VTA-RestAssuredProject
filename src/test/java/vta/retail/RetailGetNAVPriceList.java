package vta.retail;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;;;

public class RetailGetNAVPriceList {
	
	final static Logger logger = Logger.getLogger(RetailGetNAVPriceList.class);
	
	Response response = null;
	
	String getWSEndPoint() {
		try {
			InputStream stream = this.getClass().getResourceAsStream("/env.properties");      
		    Properties p = new Properties();  
		    p.load(stream);  
		    logger.info("End point URL :"+p.getProperty("wsEndPointUrl"));
		    return p.getProperty("wsEndPointUrl");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Test(description = "Test to verify web service success status code")
	void verifyWSStatusCode() {
		given()
			.get(getWSEndPoint())
		.then()
			.statusCode(200);		
	}
	
	@Test(description = "Test to verify response schema structure")
	public void verifyWSResponseSchema() {
	   given()
	   		.get(getWSEndPoint())
	   .then()
	   		.body(matchesJsonSchemaInClasspath("wsResponse.json"));
	}
	
	@Test(description = "Test to verify response contentType")
	public void verifyWSResponseContentType() {
	   given()
	   		.get(getWSEndPoint())
	   .then()
	   		.contentType("application/x-javascript;charset=utf-8");
	}
	
	@Test(description = "Test to verify response content")
	public void verifyWSResponseContent() {
	   given()
	   		.get(getWSEndPoint())
	   .then()
	   		.body(containsString("portId"))
	   		.body(containsString("asOfDate"))
	   		.body(containsString("currencyCode"))
	   		.body(containsString("8202"))
	   		.body(containsString("Final Price"))
	   		.body(containsString("Daily Price"))
	   		.body(containsString("Daily Price"))
	   		.body(containsString("Net Asset Value"));
	}
	
	@Test(description = "Test to verify web service response time")
	void verifyWSResponseTime() {
		given()
			.get(getWSEndPoint())
		.then()
			.time(lessThan(9000L));		
	}
}
