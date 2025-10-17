package ch.hearc.jee2024.demo;

import ch.hearc.jee2024.hellospring.ioc.MessagingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@RequestMapping("/send")
public class MessagingController {
    private static final Logger LOGGER = Logger.getLogger(MessagingController.class.getName());
    private MessagingService messagingService;

    @GetMapping
    public String send(){
        LOGGER.info(messagingService.send("test","sar23621@gmail.com"));
        return "test";
    }
    public MessagingController(MessagingService messagingService){
        this.messagingService = messagingService;
    }
}