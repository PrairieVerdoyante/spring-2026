package ch.hearc.jee2024.demo;

import ch.hearc.jee2024.demo.ioc.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@RequestMapping("/send")
public class MessagingController {
    private static final Logger LOGGER = Logger.getLogger(MessagingController.class.getName());

    private MessagingService mailService;
    private MessagingService smsService;

    @Autowired
    public MessagingController(@Qualifier("mailService")MessagingService mailService, @Qualifier("smsService")MessagingService smsService) {
        this.mailService = mailService;
        this.smsService = smsService;
    }

    @GetMapping("/mail")
    public String sendMail(){
        String result = mailService.send("test","test@test.com");

        LOGGER.info(result);

        return result;
    }

    @GetMapping("/sms")
    public String sendSms(){
        String result = smsService.send("test","test@test.com");

        LOGGER.info(result);

        return result;
    }


}