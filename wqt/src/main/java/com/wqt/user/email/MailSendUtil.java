package com.wqt.user.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.wqt.common.util.PropertiesUtil;


/*发送验证邮件*/
public class MailSendUtil implements Runnable {
    private String recvEmail;    //接收人邮件地址
    private String activeCode;   //验证码;
    
    public MailSendUtil(String recvEmail, String activeCode) {
        this.recvEmail = recvEmail;
        this.activeCode = activeCode;
    }
    
    public void run() {
       
        try {
        	 //1.创建连接对象，连接到邮箱服务器
	         Properties props = new Properties();
	        
	         Session session=Session.getInstance(props, new Authenticator() {
	             @Override
	             protected PasswordAuthentication getPasswordAuthentication() {
	                 /**创建一个邮箱账号:service@mac.com  123
	                  * 默认使用该账号发送邮件
	                  */
	                 //return new PasswordAuthentication("service@mac.com", "123");
	                 return new PasswordAuthentication(PropertiesUtil.rs.getProperty("email"), PropertiesUtil.rs.getProperty("emailp"));
	             }
	         });
        	// 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(PropertiesUtil.rs.getProperty("email")));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recvEmail));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://www.w7tong.com/verityEmail?emailcode="
                    + activeCode + "'>http://www.w7tong.com/verityEmail?emailcode=" + activeCode
                    + "</href></h3></body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
