package ch.hearc.jee2024.hellospring.ioc;

import java.util.logging.Logger;

public class IocCliApplication
{
    private static final Logger LOGGER = Logger.getLogger(IocCliApplication.class.getName());

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        MessagingApplication app = new MessagingApplication(emailService);
        String emailMsgResult = app.processMessage("Test message","seb.chevre@gmail.com");
        LOGGER.info(String.format("Call mail service from app, result: %s",emailMsgResult));

        SmsService smsService = new SmsService();
        app = new MessagingApplication(smsService);
        String smsMsgResult = app.processMessage("Test message 2","0797654323");
        LOGGER.info(String.format("Call sms service from app, result: %s",emailMsgResult));
    }
}
