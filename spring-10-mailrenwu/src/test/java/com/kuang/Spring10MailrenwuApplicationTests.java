package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Spring10MailrenwuApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        // 一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 发送者
        mailMessage.setFrom("15512702732@163.com");
        // 发送给谁
        mailMessage.setTo("15512702732@163.com");
        // 标题
        mailMessage.setSubject("你好-测试");
        // 文本
        mailMessage.setText("发送完成，谢谢！！");
        // 发送邮件
        javaMailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        // 一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 组装为helper,开启多文件,设置编码
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        // 主题
        helper.setSubject("复杂邮件测试");
        // 内容，开启html解析
        helper.setText("<h1>复杂邮件测试</h1><p>完成发送，谢谢！！！</p>", true);
        // 添加附件
        helper.addAttachment("1.png", new File("D:\\1.png"));
        helper.addAttachment("1.png", new File("D:\\1.png"));
        // 发送者
        helper.setFrom("15512702732@163.com");
        // 发送给谁
        helper.setTo("15512702732@163.com");
        // 发送邮件
        javaMailSender.send(mimeMessage);
    }
}
