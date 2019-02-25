package net.jetensky.inpia.spring;

import net.jetensky.inpia.spring.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.jetensky.inpia.spring.service.EmailService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application {

    private List<MessageSender> messageSenders;

    public Application(List<MessageSender> messageSenders) {

        this.messageSenders = messageSenders;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "net.jetensky.inpia.spring");
        Application application = context.getBean(Application.class);
        application.processMessages("Hello", "Pavel");
    }

    public void processMessages(String msg, String recipient) {
        if (msg == null) throw new IllegalArgumentException();
        for (MessageSender messageSender : messageSenders) {
            messageSender.sendEmail(msg, recipient);
        }

    }

}
