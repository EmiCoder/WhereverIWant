package com.example.wherever_i_want;

import com.example.wherever_i_want.domain.Mail;
import com.example.wherever_i_want.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;


@SpringBootApplication
public class WhereverIWantApplication  {

//    @Autowired
//    private SimpleMailService simpleMailService;

    public static void main(String[] args) {
        SpringApplication.run(WhereverIWantApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        Mail mail = new Mail("cellokrecik@interia.pl", "temat", "wiadomość");
//        simpleMailService.send(mail);
//    }

}
