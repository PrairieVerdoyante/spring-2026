package ch.hearc.jee2024.demo;

import ch.hearc.jee2024.demo.ioc.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/{method}")
    public String send(@PathVariable String method) {
        String result;

        switch (method.toLowerCase()) {
            case "mail":
                result = mailService.send("test", "test@test.com");
                break;
            case "sms":
                result = smsService.send("test", "test@test.com");
                break;
            default:
                result = "Unknown method" + method;
                LOGGER.warning(result);
                return result;
        }

        LOGGER.info(result);
        return result;
    }

    @GetMapping(params = "type")
    public String sendByType(@RequestParam("type") String type,
                            @RequestParam(defaultValue = "test") String message,
                             @RequestParam(defaultValue = "test@test.com") String to) {
        String result;

        switch (type.toLowerCase()) {
            case "mail":
                result = mailService.send("test", "test@test.com");
                break;
            case "sms":
                result = smsService.send("test", "test@test.com");
                break;
            default:
                result = "Unknown param";
                LOGGER.warning(result);
                break;

        }
        return result;

    }

    @GetMapping(headers = "type")
    public String sendByHeader(
            @RequestHeader("type") String type,
                @RequestParam(defaultValue = "test") String message,
                @RequestParam(defaultValue = "test@test.com") String to)
    {
        String result;

        switch (type.toLowerCase()) {
            case "mail":
                result = mailService.send(message, to);
                break;
            case "sms":
                result = smsService.send(message, to);
                break;
            default:
                result = "Unknown type: " + type;
                LOGGER.warning(result);
                return result;
        }

        LOGGER.info(result);
        return result;
    }


}