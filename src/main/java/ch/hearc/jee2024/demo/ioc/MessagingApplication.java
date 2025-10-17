package ch.hearc.jee2024.demo.ioc;

public class MessagingApplication {

    private MessagingService messagingService = null;

    public MessagingApplication(MessagingService service){
        this.messagingService = service;
    }

    public String processMessage(String message, String destinataire){
        return messagingService.send(message, destinataire);
    }
}
