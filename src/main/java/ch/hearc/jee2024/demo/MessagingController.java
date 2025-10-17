package ch.hearc.jee2024.demo;

import ch.hearc.jee2024.demo.ioc.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@RequestMapping("/send")
public class MessagingController {
    private static final Logger LOGGER = Logger.getLogger(MessagingController.class.getName());

    @Autowired
    private MessagingService messagingService;

    @GetMapping
    public String send(){
        String result = messagingService.send("test","test@test.com");

        LOGGER.info(result);

        return result;
    }
}