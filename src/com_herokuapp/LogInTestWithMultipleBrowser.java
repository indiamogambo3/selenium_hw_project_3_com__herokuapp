package com_herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-3 - Project Name: com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class LogInTestWithMultipleBrowser {

    static String browser = "Edge";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {

        //If condition to launch selected browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Invalid browser name!!");
        }

        //Open URL in browser
        driver.get(baseUrl);
        //Maximise browser
        driver.manage().window().maximize();
        //Set Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get title page
        String getTitle = driver.getTitle();
        System.out.println("Page title is: " + getTitle);

        //Get current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        //Get page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source is: " + pageSource);

        //Find username field element
        WebElement userName = driver.findElement(By.id("username"));
        //Type username in username field
        userName.sendKeys("mukz123@gmail.com");

        //Find password field element
        WebElement password = driver.findElement(By.id("password"));
        //Type password in password field
        password.sendKeys("Mogambo123");

        //close the driver
        driver.close();
    }
}
