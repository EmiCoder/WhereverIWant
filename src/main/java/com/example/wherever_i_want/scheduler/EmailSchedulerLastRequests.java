package com.example.wherever_i_want.scheduler;

import com.example.wherever_i_want.domain.Mail;
import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.repository.RequestRepository;
import com.example.wherever_i_want.service.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
public class EmailSchedulerLastRequests {

    private static final String SUBJECT = "User's requests";
    private static final int DAYS_BEFOR = 1;
    @Value("${admin.mail}")
    private String adminEmail;

    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private RequestRepository requestRepository;


    @Scheduled(cron = "0 0 13 * * *")
    public void sendEmailWithRequestsDetails() {

        List<Request> list = requestRepository.findAll();
        simpleMailService.send(new Mail(adminEmail, SUBJECT + ": " + getDateBefor(), getEmailMessage(list)));

    }

    private String getEmailMessage(List<Request> list) {
        String message = "";
        for (Request request : list) {
           if (request.getRequestDate().equals(getDateBefor())) {
               message += "UserId: " + request.getUser().getId() +
                            ", Temp: " + request.getTemperature() +
                            ", Mth: " + request.getMonth() +
                            ", Country: " + request.getCountry() + "\n";
           }
        } return message;
    }

    private String getDateBefor() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(Date.from(Instant.now().minus(Duration.ofDays(DAYS_BEFOR))));
    }
}
