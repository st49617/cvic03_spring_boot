package net.jetensky.inpia.cvic03_demo.controller;

import net.jetensky.inpia.cvic03_demo.dao.IssueReport;
import net.jetensky.inpia.cvic03_demo.dao.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IssuesController {

    @Autowired
    IssueReportRepository issueReportRepository;

    @GetMapping("/issuereport")
    public String issueReport(Model model) {
        model.addAttribute("issueReport", new IssueReport());
        return "issues/issuereport_form";
    }

    @GetMapping("/issues")
    public String issues(Model model) {
        List<IssueReport> issues = issueReportRepository.findAll();
        model.addAttribute("issues", issues);
        return "issues/issuereport_list";
    }

    @PostMapping("/issuereport")
    public String issueReportSubmit(IssueReport issueReport) {
        issueReportRepository.save(issueReport);
        return "issues/issuereport_form";
    }
}
