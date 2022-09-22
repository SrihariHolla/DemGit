package com.sgtesting.restStepdefinition;

import java.io.File;
import java.net.http.HttpRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarpicocli.CommandLine.Command;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionDemo {
	RequestSpecification httpRequest;
	Response response;
	@Test(priority = 1)
	@Given("^I provide endpoint$")
	public void  I_provide_endpoint()
	{
		try {
			RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	@And("^I create object for requestspecification$")
	public void I_create_object_for_requestspecification()
	{
		try {
	 httpRequest=RestAssured.given();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test(priority = 3)
	@When("^ I_proide_body_for_file$")
	public void I_proide_body_for_file()
	{
		try {
			File f1=new File(".\\DataFiles\\Signin.json");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(f1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test(priority = 4)
	@And("^I execute post Method$")
	public void I_execute_post_Method()
	{
		try {
		response=httpRequest.post();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 5)
	@Then("^I find 201 statuscode$")
	public void I_find_201_statuscode()
	{
		try {
			int statuscode=response.getStatusCode();
			System.out.println("statusCode:"+statuscode);
			Assert.assertEquals(201, statuscode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
