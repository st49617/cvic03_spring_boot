package net.jetensky.inpia.cvic03_demo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IssueReport {
    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private String url;

    public IssueReport() {
        System.out.println("New instance created");
    }

    public IssueReport(String description, String url) {
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
