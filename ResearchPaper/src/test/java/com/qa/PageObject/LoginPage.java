package com.qa.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	public WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy(id="login")
	@CacheLookup
	WebElement login;
	
	@FindBy(id="inst-username")
	@CacheLookup
	WebElement userNameEle;
	
	@FindBy(id="inst-passwd")
	@CacheLookup
	WebElement pwdEle;
	
	
	public WebElement userNameField() {
		return userNameEle;
	}
	
	public WebElement pwdField() {
		
		return pwdEle;
	}
	
	public WebElement loginButton() {
		return login;
	}
	
	
	
}
