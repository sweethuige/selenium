package pageObject;

import framework.BasePage;
import framework.Excel;
import org.apache.tools.ant.taskdefs.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 2019/1/6.
 */
public class RolePage extends BasePage {
    //content-item
    @FindBy(name= "role-name")
    List<WebElement> roleNameInputList;
    //btn-group-item
    @FindBy(className = "btn-group-item")
    List<WebElement> insertroleButtonList;
    @FindBy(name="button")
    List<WebElement> yesButtonList;


//    @FindBy(xpath = "/html/body/div/div/div/div[2]/input[1]")
//    WebElement username_inputBox;
//
//    @FindBy(xpath = "/html/body/div/div/div/div[2]/input[2]")
//    WebElement password_inputBox;
//
//    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/form/div[3]/div/div[1]/input")
//    WebElement verifypic_inputBox;
//
//    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/form/div[4]/div/div/div[1]/div/input")
//    WebElement serveraddress_inputBox;
//
//    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/form/div[4]/div/div/div[2]/ul[2]/li[2]")
//    WebElement serveraddress_selector;

    @FindBy(xpath = "/html/body/div/div/section/section/main/div/div[1]/button[1]")
    WebElement insertRoleButton;
//
    public RolePage(WebDriver driver) {
        super(driver);
    }

    public void insertRole() throws Exception {
        Excel excel = new Excel();
        callWait(5);
        click(insertroleButtonList.get(0));

        type(roleNameInputList.get(0), "管理员3");
        click(yesButtonList.get(3));
//        excel.setExcelFile("E:\\Java_project\\XTPTest_selenium\\suites\\test-data.xlsx", "Login_info");
//        //Excel中的行和列都是从0开始的不是从1
//        type(username_inputBox, excel.getCellData(1, 0));
//        type(password_inputBox, excel.getCellData(1, 1));
//        type(username_inputBox, "V2test_Admin_gys2");
//        type(password_inputBox, "123456");
//        type(verifypic_inputBox, excel.getCellData(1, 2));
//        click(serveraddress_inputBox);
//        callWait(2);
//        click(serveraddress_selector);
//        callWait(2);




    }


}
