package net.jetensky.inpia.spring;

import net.jetensky.inpia.spring.service.EmailService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    public void processMessagesOK() {
        EmailServiceMock emailServiceMock = new EmailServiceMock();
        Application a = new Application(emailServiceMock);
        a.processMessages("a", "b");
        assertTrue(emailServiceMock.sent);

    }

    @Test(expected = IllegalArgumentException.class)
    public void processMessagesFail() {
        Application a = new Application(new EmailService());
        a.processMessages(null, "b");

    }

    private class EmailServiceMock extends EmailService {
        private boolean sent = false;

        @Override
        public void sendEmail(String msg, String name) {
            sent = true;
        }
    }
}