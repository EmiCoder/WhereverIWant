package com.example.wherever_i_want.simpleEmailService;

import com.example.wherever_i_want.domain.Mail;
import com.example.wherever_i_want.service.SimpleMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleMailServiceTestSuite {

    @InjectMocks
    private SimpleMailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        Mail mail = new Mail("test@test.com", "Test", "Test message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        simpleEmailService.send(mail);
        verify(javaMailSender, times(1)).send(mailMessage);
    }
}
