package net.jetensky.inpia.cvic03_demo.controller;

import net.jetensky.inpia.cvic03_demo.dao.IssueReport;
import net.jetensky.inpia.cvic03_demo.dao.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssuesRestController {

    @Autowired
    IssueReportRepository issueReportRepository;

    @GetMapping("/api/issue/list")
    public List<IssueReport> issues() {
        return issueReportRepository.findAll();
    }

}
