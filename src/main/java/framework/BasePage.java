package framework;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;
    public static String pageTitle;
    public static String pageUrl;
    private static Logger logger = Logger.getLogger(BasePage.class);

    //构造函数
    protected BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
    public BasePage(){

    }

    //在文本框内输入字符
    protected void type(WebElement element, String text) {
        try {
            if (element.isEnabled()) {
                element.clear();
                logger.info("Clean the value if any in" + element.toString() + ".");
                element.sendKeys(text);
                logger.info("Type value is" + text + ".");
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + ".");
        }
    }

    //点击鼠标左键
    protected void click(WebElement element) {
        try {
            if (element.isEnabled()) {
                element.click();
                logger.info("Element:" + element.toString() + "was clicked.");

            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    //文本输入框执行清除操
    protected void clean(WebElement element) {
        try {
            if (element.isEnabled()) {
                element.clear();
                logger.info("Element" + element.toString() + "was cleaned.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    //判断一个页面元素是否显示在当前页面
    protected void verifyElementIsPresent(WebElement element) {
        try {
            if (element.isDisplayed()) {
                logger.info("This Element" + element.toString().trim() + "is present.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    //获取当前页面的Title
    protected String getCurrentPageTitle() {
        pageTitle = driver.getTitle();
        logger.info("Current page title is" + pageTitle);
        return pageTitle;
    }

    //获取当前页面的URL
    protected String getCurrentPageUrl() {
        pageUrl = driver.getCurrentUrl();
        logger.info("Current page title is " + pageUrl);
        return pageUrl;
    }

    //隐式等待
    public void callWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        logger.info("隐式等待" + time + "秒");
    }

    //处理多窗口之间切换
    public void switchWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        logger.info("当前窗口数量：" + handles.size());
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            if (currentWindow == it.next()) {
                continue;
            }
            try {
                driver.close();
                WebDriver window = driver.switchTo().window(it.next());
                logger.info("new page title is" + window.getTitle());
            } catch (Exception e) {
                logger.error("无法切换到新打开窗口" + e.getMessage());
            }
            //driver.close(); //关闭当前焦点所在的窗口

        }
        //driver.switchTo().window(currentWindow);//回到原来页面

    }


}
