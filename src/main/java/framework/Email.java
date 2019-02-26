package framework;

import org.testng.annotations.AfterTest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    /* @Test*/ /*不能放到main方法上*/
    public static void main(String[] args) {

        sendEmail();
    }
    public static void sendEmail() {
        try {
            String toAddress = "643261634@qq.com";
// 配置发送邮件的环境属性
            final Properties


                    props = new Properties();

            /* 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
              mail.user / mail.from*/

// 表示SMTP发送邮件，需要进行身份验证
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");
// 发件人的账号
            props.put("mail.user", toAddress);
// 访问SMTP服务时需要提供的密码
            props.put("mail.password", "knsanqvnslapbejg");

// 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
// 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
// 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
// 设置发件人
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);

// 设置收件人
            String toList = "714837805@qq.com";
            InternetAddress[] iaToList = new InternetAddress().parse(toList); // 设置多个收件人
            message.setRecipients(Message.RecipientType.TO, iaToList);

// 设置抄送
//        InternetAddress cc = new InternetAddress("wuguohui@cvte.com");
//        message.setRecipient(RecipientType.CC, cc);

// 设置密送，其他的收件人不能看到密送的邮件地址
// InternetAddress bcc = new InternetAddress("aaaaa@163.com");
// message.setRecipient(RecipientType.CC, bcc);

// 设置邮件标题
            message.setSubject("Web Auto Test Mail");
//            message.setContent(new MimeMultipart("huihui"));
//            将测试报告的html文件内容读取写入到content中
            message.setContent(ReadReportXml.eMailString(), "text/html;charset=UTF-8");

// 发送邮件
            Transport.send(message);
            System.out.println("成功发送邮件");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
