package net.jetensky.inpia.spring.service;

import net.jetensky.inpia.spring.dao.EmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageSender {

    @Autowired
    EmailDao emailDao;

    public void sendEmail(String msg, String name) {
        System.out.println("Sending e-mail with " + msg + " to " + name);
        emailDao.save(name);
    }
}
