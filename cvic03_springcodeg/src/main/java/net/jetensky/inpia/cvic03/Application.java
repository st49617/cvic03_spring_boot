package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.spring.service.MessageSender;

import java.util.List;

public class Application implements Consumer {

    private List<MessageSender> messageSenders;

    public Application(List<MessageSender> messageSenders) {

        this.messageSenders = messageSenders;
    }

    public static void main(String[] args) {
        MessageServiceInjector.getConsumer()
                .processMessages("Hello", "Pavel");
    }

    @Override
    public void processMessages(String msg, String recipient) {
        for (MessageSender messageSender : messageSenders) {
            messageSender.sendEmail(msg, recipient);
        }

    }
}
