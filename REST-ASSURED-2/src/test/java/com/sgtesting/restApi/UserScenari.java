package com.sgtesting.restApi;

import java.io.File;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenari {
	public static String user_id=null;
	public static String auth_Token=null;
	public static String comp_id=null;

	@Test(priority = 1)
	public void post()
	{
		try {
			RestAssured.baseURI="https://reqres.in/api/users";
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\post.json");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(f1);
			Response response=httpRequest.post();
			System.out.println(response.asString());
			int Statuscode=response.getStatusCode();
			System.out.println(Statuscode);
			Assert.assertEquals(201, Statuscode);
			JsonPath js=response.jsonPath();
			user_id=js.getString("id");
			System.out.println(user_id);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test(priority =2)
	public void put()
	{
		try {

			RestAssured.baseURI="https://reqres.in/api/users/2"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\editUser.json");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(f1);
			Response response=httpRequest.put();
			System.out.println(response.asPrettyString());



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority =3)

	public void getuser()
	{
		try {
			RestAssured.baseURI="https://reqres.in/api/users"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			httpRequest.header("Content-Type","application/json");
			Response response=httpRequest.get();
			System.out.println(response.asPrettyString());

			Headers headers=response.getHeaders();
			for (Header kk : headers)
			{
				System.out.println(kk);
			}
			String contenttype=headers.getValue("Content-Type");
			Assert.assertEquals("application/json; charset=utf-8", contenttype, "header issue");
			System.out.println(contenttype);

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority =4)
	public void signin()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\Signin.json");
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(f1);
			Response response=httpRequest.post();
			System.out.println(response.asPrettyString());
			JsonPath js=response.jsonPath();
			auth_Token=js.getString("auth_token");
			System.out.println(auth_Token);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority =5)
	public void createcompany()
	{
		try
		{
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies";
			RequestSpecification httpRequest=RestAssured.given();
			File f1=new File(".\\DataFiles\\createcompany.json");
			httpRequest.header("Content-Type","application/json");
			httpRequest.header("Authorization",auth_Token);
			httpRequest.body(f1);
			Response response=httpRequest.post();
			System.out.println(response.asString());
			JsonPath js=response.jsonPath();
			comp_id=js.getString("id");
			System.out.println(comp_id);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority =6)
	public void getcompany()
	{
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+comp_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization",auth_Token);
		Response response=httpRequest.get();
		Headers headers=response.getHeaders();
		for(Header kk:headers)
		{
			System.out.println(kk);
		}
		String contenttype=headers.getValue("Content-Type");
		Assert.assertEquals("application/json; charset=utf-8", contenttype);
		System.out.println(contenttype);


	}
	@Test(priority =7)
	public void deletecompany()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+comp_id;
		RequestSpecification httpRequest=	RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization",auth_Token);
		Response response=httpRequest.delete();
		System.out.println(response.asPrettyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

