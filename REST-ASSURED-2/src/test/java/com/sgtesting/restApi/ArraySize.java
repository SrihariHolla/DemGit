package com.sgtesting.restApi;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ArraySize {
	public static String user_id=null;
	public static String auth_Token=null;
	public static String comp_id=null;
	RequestSpecification httpRequest;

	@Test(priority =1)
	public void signin()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
			httpRequest=RestAssured.given();
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
	@Test(priority =2)
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

	@Test(priority =3)
	public void getc()
	{
		try {

			RestAssured.baseURI = "https://enigmatic-meadow-39517.herokuapp.com/api/v1/companies/"+comp_id;

			//Provide HTTP method type - GET, and URL to get all employees
			//This will give respose
			httpRequest.header("Authorization",auth_Token);
			
			Response response=httpRequest.get();
			
			String ct = response.asPrettyString();
			System.out.println(ct);
			//use JsonPath from Rest-Assured to get list of employee id
			List<String> employees = response.jsonPath().getList("company.name");
			System.out.println(employees.size());








		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
