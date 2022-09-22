package com.sgtesting.restApi;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateUserPojoEXE {

	@Test
	public void createuser()
	{
		try {
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
		RequestSpecification httpRequest=RestAssured.given();
		
		CreateuserPojo[] user= {new CreateuserPojo("user11@gmail.com","user11","demo","9867454321","Bangalore","Karnataka","560056"),
				new CreateuserPojo("user12@gmail.com","user12","demo","9867454321","Bangalore","Karnataka","560056")
		};

	/*	user.setEmail("user1@gmail.com");
		user.setFirst_name("user1");
		user.setLast_name("demo");
		user.setPhone_number("9867454321");
		user.setAddress("Bangalore");
		user.setState("Karnataka");
		user.setZipcode("560056");*/
		
		ObjectMapper obj=new ObjectMapper();
	String data=obj.writerWithDefaultPrettyPrinter().writeValueAsString(user);
	System.out.println(data);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
