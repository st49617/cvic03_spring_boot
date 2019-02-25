package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.spring.service.MessageSender;

public class EmailService implements MessageSender {
    public void sendEmail(String msg, String recipient) {
        System.out.println("Sending " + msg +
                " to " + recipient);
    }
}
