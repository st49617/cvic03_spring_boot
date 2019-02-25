package net.jetensky.inpia.cvic03;

import java.util.Collections;

public class MessageServiceInjector {
    public static Consumer getConsumer() {
        Application app = new Application(Collections.singletonList(new EmailService()));
        System.out.println("Instance of application " +
                "with wired dependencies created");
        return app;
    }
}
