package ch.hearc.jee2024.demo.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/** Service simulant un envoi de mail*/
@Component
@Qualifier("mailService")
public class EmailService implements MessagingService{
    //utilisation d'un logger java
    private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Override
    public String send(String message, String destinataire) {
        LOGGER.info(String.format("Mail: [%s] sent to %s", message, destinataire));
        return "Mail message successfully send!";
    }
}