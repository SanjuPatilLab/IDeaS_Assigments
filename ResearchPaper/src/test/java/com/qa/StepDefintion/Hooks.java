package com.qa.StepDefintion;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.PageObject.Utils;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

		
	@Before("@ResearchPaper_Download")
	public void deleteDownloadFile() {
		
		System.out.println("DeleteFile ----");
		Utils.deleteFileExists("paper.pdf");
		
	}
	
	
}
