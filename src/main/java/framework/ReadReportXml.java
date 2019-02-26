package framework;

import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadReportXml {
    public static boolean hasDigit(String content) {

        boolean flag = false;

        Pattern p = Pattern.compile(".*\\d+.*");

        Matcher m = p.matcher(content);

        if (m.matches())

            flag = true;

        return flag;

    }

    /**
     * 获取到最新的目录
     *
     * @return 返回目录的名称
     */
    private static String getLastesFolder() {
        File path = new File("./target/");
        //列出该目录下所有文件和文件夹
        File[] files = path.listFiles();
        //按照文件最后修改日期倒序排序
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return (int) (file2.lastModified() - file1.lastModified());
            }
        });
        //取出第一个(即最新修改的)文件，打印文件名
        for (File file : files) {
            System.out.println(file.getName());
            if (hasDigit(file.getName())) {
                return file.getName();
            }
        }
        return files[0].getName();
    }

   /* public static String readSuitsXml() {
        XmlParser xmlParser = new XmlParser("./target/"+getLastesFolder()+"/suite1_test1_results.html");
        List elements = xmlParser.getElementsByTag(xmlParser.getRootElement(), "testcase");
        int testCasePass = 0, testCaseFail = 0, testCaseSkip = 0;
        for (Object element1 : elements) {
            Element element = (Element) element1;
            if (xmlParser.getElementByTag(element, "failure") == null) {
                baseHtml += "<li class=\"list-group-item list-group-item-success\"><strong>" + xmlParser.
                        getElementByAttr(element, "name") + "</strong></li>\n";
                testCasePass += 1;
            }else {
                baseHtml += "<li class=\"list-group-item list-group-item-danger\"><strong>" + xmlParser.
                        getElementByAttr(element, "name") + "</strong></li>\n";
                testCaseFail += 1;
            }
        }
        baseHtml +="</ul>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        baseHtml = baseHtml.replace("SUCCESSCOUNT", String.valueOf(testCasePass));
        baseHtml = baseHtml.replace("FAILCOUNT", String.valueOf(testCaseFail));
        baseHtml = baseHtml.replace("SKIPCOUNT", String.valueOf(testCaseSkip));
        return baseHtml;
    }*/

    /**
     * @param
     */
    public static String eMailString() {
        //String info="";  
        StringBuffer buff = new StringBuffer();
        InputStreamReader in = null;
        BufferedReader br = null;
        String path = "D:\\work\\work_project\\workspace\\testlogin\\test-output\\html\\suite1_test1_results.html";
        File file = new File(path);
        try {
            in = new InputStreamReader(new FileInputStream(file));
            br = new BufferedReader(in);
            String line = null;

            while ((line = br.readLine()) != null) {
                //System.out.println(line);  
                buff.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();
                }
            }
        }
        return buff.toString();
    }

}
