package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dice_jobserach {
public static void main(String [] args) {
	//set up chrome driver path
	WebDriverManager.chromedriver().setup();

//	invoke selenium webdriver
	WebDriver driver=new ChromeDriver();
//	fullscreen
	driver.manage().window().fullscreen();
//	set universal wait time in case web page is slow
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String url="https://dice.com";
	String actualTitle=driver.getTitle();
	String expectedTitle="Find Jobs in Tech | Dice.com";
	driver.get(url);
	String keyword="java developer";
	driver.findElement(By.id("search-field-keyword")).clear();
	driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
	String location="New York";
	driver.findElement(By.id("search-field-location")).clear();
	driver.findElement(By.id("search-field-location")).sendKeys(location);
	driver.findElement(By.id("findTechJobs")).click();
	if(actualTitle.equals(expectedTitle)) {
		System.out.println("Step pass. Dice homepage succesfully loaded");
	}else {
		System.out.println("Step fail. Dice homepage failed");
	}
	}
}

