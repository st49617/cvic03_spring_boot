package net.jetensky.inpia.cvic03;


import net.jetensky.inpia.cvic03.messagesender.MessageSender;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageSender {

    public void sendMessage(String msg, String name) {
        System.out.println("Sending SMS with " + msg + " to " + name);
    }
}
