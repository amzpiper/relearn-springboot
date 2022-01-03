package com.kuang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class Spring10MailrenwuApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        javaMailSender.send(mailMessage);
    }

}
