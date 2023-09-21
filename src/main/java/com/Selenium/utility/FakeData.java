package com.Selenium.utility;

import com.github.javafaker.Faker;

public class FakeData {
	
	Faker faker = new Faker();

	public String username = faker.name().fullName();
	public String phone = faker.number().digits(10);
	public String email = faker.internet().emailAddress();
	public String password = faker.internet().password();
	
	
	
	

}
