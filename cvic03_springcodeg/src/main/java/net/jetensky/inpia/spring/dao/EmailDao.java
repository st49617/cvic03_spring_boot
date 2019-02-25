package net.jetensky.inpia.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class EmailDao {
    public void save(String name) {
        System.out.println("Saving " + name + " to database");
    }
}
