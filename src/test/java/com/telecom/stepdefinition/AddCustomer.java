package com.telecom.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AddCustomer {
    static WebDriver driver;
	@Given("user launches demo telecom websie")
	public void user_launches_demo_telecom_websie() {
	    WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.get("http://www.demo.guru99.com/telecom/");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	}

	@Given("user click add customer")
	public void user_click_add_customer() {
		driver.findElement(By.xpath("(//*[text()='Add Customer'])[1]")).click();
	   
	}

	@When("user enter all the details")
	public void user_enter_all_the_details() {
		driver.findElement(By.xpath("//*[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys("Vijay");
		driver.findElement(By.id("lname")).sendKeys("kumaar");
		driver.findElement(By.id("email")).sendKeys("vijayviswa95@gmail.com");
		driver.findElement(By.xpath("//*[@name='addr']")).sendKeys("please create my ID");
		driver.findElement(By.id("telephoneno")).sendKeys("9597666445");
	     
	}

	@When("user enter submit button")
	public void user_enter_submit_button() {
	    driver.findElement(By.xpath("//*[@type='submit']")).click();
	    
	}

	@Then("user customer id generated")
	public void user_customer_id_generated() {
	    WebElement equal = driver.findElement(By.xpath("(//table//tr//td)[3]"));
	    System.out.println(equal.getText());
	    Assert.assertNotEquals(equal, "Please Note Down Your CustomerID");
	  
	}

	

}
