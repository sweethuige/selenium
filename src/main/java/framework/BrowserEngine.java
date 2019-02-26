package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserEngine {
    public String browserName;
    public String serverURL;
    public WebDriver driver;

    public void initConfigData() throws IOException {
       /*Java中有个比较重要的类Properties（Java.util.Properties），主要用于读取Java的配置文件,在Java中，其配置文件常为.properties文件，格式为文本文件，文件的内容的格式是“键=值”的格式，
        文本注释信息可以用"#"来注释。主要方法如下：
        getProperty ( String key)  通过参数 key ，得到 key 所对应的 value
        load ( InputStream inStream) 从输入流中读取属性列表（键和元素对），以供 getProperty ( String key) 来搜索
        setProperty ( String key, String value) 调用 Hashtable 的方法 put 。他通过调用基类的put方法来设置 键 - 值对
        store ( OutputStream out, String comments)  与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。
        clear ()，清除所有装载的 键 - 值对
        */

        Properties p = new Properties();
        //加载配置文件
        InputStream ips = new FileInputStream("src\\main\\resources\\config.properties");
        //InputStream是抽象类，FileInputStream是InputStream的子类
        p.load(ips);

        //日志

        browserName = p.getProperty("browserName");
        //
        serverURL = p.getProperty("URL");
        //
        ips.close();

    }

    public WebDriver getBrowser() {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            //

        } else if (browserName.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "E:\\Java_project\\XTPTest_selenium\\src\\main\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            //
        }
        driver.get(serverURL);
        //
        driver.manage().window().maximize();
        //
        callWait(5);
        return driver;
    }

    public void tearDown() throws InterruptedException {
        //
        driver.quit();
        Thread.sleep(3000);
    }

    //隐式等待
    public void callWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        //
    }


}
