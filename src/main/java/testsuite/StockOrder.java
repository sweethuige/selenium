package testsuite;

import framework.BrowserEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.RolePage;

import java.io.IOException;

public class StockOrder {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException {
        BrowserEngine browserEngine=new BrowserEngine();
        browserEngine.initConfigData();
        driver=browserEngine.getBrowser();
    }

    @Test
    public void LoginSystem()throws Exception{
        LoginPage loginpage= PageFactory.initElements(driver,LoginPage.class);
        loginpage.Login();
        RolePage rolePage = PageFactory.initElements(driver, RolePage.class);
        rolePage.insertRole();
//        driver.get(url);
//        UserPage userPage = PageFactory.initElements(driver,UserPage.class);
    }


}
