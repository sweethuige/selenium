package pageObject;

import framework.BasePage;
import framework.Excel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 2019/1/6.
 */
public class LoginPage extends BasePage {
    @FindBy(xpath = "/html/body/div/div/div/div[2]/input[1]")
    WebElement username_inputBox;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/input[2]")
    WebElement password_inputBox;

    @FindBy(xpath = "/html/body/div/div/div/div[2]/button")
    WebElement Login_Button;
    //获取角色管理模块
    @FindBy(className = "el-menu-item")
    List<WebElement> userModle;
//
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login() throws Exception {
        Excel excel = new Excel();
//        excel.setExcelFile("E:\\Java_project\\XTPTest_selenium\\suites\\test-data.xlsx", "Login_info");
//        //Excel中的行和列都是从0开始的不是从1
//        type(username_inputBox, excel.getCellData(1, 0));
//        type(password_inputBox, excel.getCellData(1, 1));
        type(username_inputBox, "V2test_Admin_gys2");
        type(password_inputBox, "123456");
        click(Login_Button);
        click(userModle.get(4));

    }


}
