package net.jetensky.inpia.cvic03.messagesender;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmailSender implements MessageSender {

    public void sendMessage(String msg, String name) {
        System.out.println("Sending e-mail with " + msg + " to " + name);
    }

    @PostConstruct
    public void loadCache() {
        System.out.println("Loading cache");
    }
}
