package net.jetensky.inpia.cvic03.controller;

import net.jetensky.inpia.cvic03.dao.IssueReport;
import net.jetensky.inpia.cvic03.dao.IssueReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class IssueController {
    IssueReportRepository issueReportRepository;

    public IssueController(IssueReportRepository issueReportRepository) {
        this.issueReportRepository = issueReportRepository;
    }

    @GetMapping("/issuereport")
    public String getReport(Model model, @RequestParam(name = "submitted", required = false) boolean submitted) {
        model.addAttribute("submitted", submitted);
        model.addAttribute("issuereport", new IssueReport());
        return "issues/issuereport_form";
    }

    @PostMapping(value="/issuereport")
    public String submitReport(IssueReport issueReport, RedirectAttributes ra) {
        this.issueReportRepository.save(issueReport);
        ra.addAttribute("submitted", true);
        return "redirect:/issuereport";
    }

    @GetMapping("/issues")
    public String getIssues(Model model) {
        model.addAttribute("issues", this.issueReportRepository.findAllButPrivate());
        return "issues/issuereport_list";
    }
}