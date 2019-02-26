package testsuite;

import framework.Calculator;
import framework.Email;
import framework.ExcelData;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class CalculatorExcel {
    Calculator cal=new Calculator();
    @DataProvider(name="num")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("testdata", "calculator");
        return e.getExcelData();
    }
    @Test(dataProvider="num")
    public void testAdd(HashMap<String, String> data){
//        System.out.println(data.toString());
        float num1=Float.parseFloat(data.get("num1"));
        float num2=Float.parseFloat(data.get("num2"));
        float expectedResult=Float.parseFloat(data.get("result"));
//        System.out.println(expectedResult);
//
//        System.out.println(cal.add(num1, num2));
        float actual = cal.add(num1, num2); //float必须是小写，不能是大写，大写报错
//
        Assert.assertEquals(actual, expectedResult);


    }

}
