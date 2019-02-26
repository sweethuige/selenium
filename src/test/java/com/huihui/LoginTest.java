package com.huihui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", "E:\\Java_project\\XTPTest_selenium\\src\\main\\resources\\IEDriverServer.exe");
        //WebDriver driver= new InternetExplorerDriver();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testpolicycloud.ezhiyang.com");
        String url = driver.getCurrentUrl();
    }

}
