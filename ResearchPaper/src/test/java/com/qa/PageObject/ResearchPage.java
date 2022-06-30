package com.qa.PageObject;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResearchPage {

public WebDriver rDriver;
	
	public ResearchPage(WebDriver Driver){
		
		rDriver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	
	@FindBy(id="paperpdf")
	@CacheLookup
	WebElement fullPaper;
	
	@FindBy(id="instlogin-link")
	@CacheLookup
	WebElement instlogin_link;
	
	@FindBy(xpath="//p[1]")
	@CacheLookup
	WebElement homePage_text;
	
	@FindBy(id="paper-error")
	@CacheLookup
	WebElement pageError;
	
	
	public String getErrorMessageText() {
		
		return pageError.getText();
		
	}
	
	public String getStatusCode() {
		
		return pageError.getAttribute("status");
	}
	
	public String gethomePage_text() {
		
		return homePage_text.getText();
		
	}
	
	public void clickOn(String element) {
		
		if(element.equalsIgnoreCase("Full Page")){
			
			fullPaper.click();
			
		}else if(element.equalsIgnoreCase("institutional login page")) {
			
			instlogin_link.click();
		}
		
		
		
	}
	
	
	
}


