package com.sgtesting.PracticeAPI;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 {
	
	@Test(priority = 1,enabled=false)
	public void create()
	{
		try {
			RestAssured.baseURI="https://fakerestapi.azurewebsites.net/api/v1/Activities";
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\ActivitiesPost.json");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(f1);
			
			Response response=httpRequest.post();
			System.out.println(response.asPrettyString());
			
			given().when().get().then()
			.statusCode(200).body(JsonSchemaValidator.matchesJsonSchema(f1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2,enabled=false)
	public void getActivities()
	{
		try {
			RestAssured.baseURI="https://fakerestapi.azurewebsites.net/api/v1/Activities";
			RequestSpecification httpRequest=RestAssured.given();
			
			Response response=httpRequest.get();
			System.out.println(response.asPrettyString());
			
			Headers headers=response.getHeaders();
			for (Header kk : headers) {
				System.out.println(kk);
				
			}
			String contenttype=headers.getValue("Content-type");
			Assert.assertEquals("application/json; charset=utf-8; v=1.0", contenttype);
			System.out.println(contenttype);
			
			given().when().get().then()
			.assertThat().statusCode(200).body(JsonSchemaValidator.matchesJsonSchema(new File(".\\DataFiles\\jsonchemaFile.json")));
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3,enabled=false)
	public void deleteActivities()
	{
		try {
		RestAssured.baseURI="https://fakerestapi.azurewebsites.net/api/v1/Activities/0";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.delete();
		System.out.println(response.asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 4)
	public void getCountry()
	{
		try {
			RestAssured.baseURI="https://restcountries.com/v2/capital/delhi";
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\ActivitiesPost.json");
			httpRequest.header("Content-Type","application/json");
		//	httpRequest.body(f1);
			
			Response response=httpRequest.get();
			System.out.println(response.asString());
			
			Headers headers=response.getHeaders();
			for (Header header : headers) {
				System.out.println(header);
			}
			String contenttype=headers.getValue("Content-Type");
			Assert.assertEquals("application/json", contenttype);
			System.out.println(contenttype);
			
			given().when().get().then()
			.assertThat().statusCode(200).body(JsonSchemaValidator.matchesJsonSchema(new File(".\\DataFiles\\countryschemafile.json")));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
