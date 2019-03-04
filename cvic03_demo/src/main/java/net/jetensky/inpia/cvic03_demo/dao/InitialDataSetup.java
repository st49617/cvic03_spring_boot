package net.jetensky.inpia.cvic03_demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialDataSetup {
    @Autowired
    IssueReportRepository issueReportRepository;

    @PostConstruct
    public void addSomeIssues() {
        issueReportRepository.save(
                new IssueReport("Google", "www.google.com")
        );
        issueReportRepository.save(
                new IssueReport("Britské listy", "www.blisty.com")
        );
    }
}
