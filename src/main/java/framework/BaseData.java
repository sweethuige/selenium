package framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/6.
 */
public class BaseData {

    @DataProvider(name="user")
    public Object[][] User(){
        return new Object[][]{
                {"root","password"},
                {"asdf","asfa"},
                {"vcz","afwe"}
        };
    }
    @Test(dataProvider = "user")
    public void verifyUser(String userName,String password){
        System.out.println("userName:"+userName+"   password:"+password);
    }
    //迭代器
//    @DataProvider(name="data")
//    public Iterator<Object[]> dataForTestMethod(Method method) throws FileNotFoundException {
//        String sheetName = "Sheet1";
//        return (Iterator<Object[]>) new ExcelDataProvider(sheetName);
//    }
    @Test(dataProvider = "data")
    public void interfaceTest(Map<String,String> map) {
        String caseName = map.get("用例名称");
        String xieyi = map.get("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ");
        System.out.println("caseName" + caseName + "xieyi" + xieyi);

    }
}
