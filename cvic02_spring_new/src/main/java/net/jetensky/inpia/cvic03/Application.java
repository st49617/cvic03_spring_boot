package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.cvic03.messagesender.EmailSender;
import net.jetensky.inpia.cvic03.messagesender.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

    @Autowired
    EmailSender sender;

    public Application() {
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("net.jetensky.inpia.cvic03");
        Application app = context.getBean(Application.class);
        app.processMessages("Hello", "Pavel");
    }

    public void processMessages(String msg, String recipient) {
        if (msg==null) throw new IllegalArgumentException("msg cannot be null");
         sender.sendMessage(msg, recipient);
    }

}
