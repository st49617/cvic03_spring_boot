package net.jetensky.inpia.cvic03.controller;

import java.util.List;
import java.util.Optional;

import net.jetensky.inpia.cvic03.dao.IssueReport;
import net.jetensky.inpia.cvic03.dao.IssueReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/issues")
public class IssueRestController {
    private IssueReportRepository issueReportRepository;

    public IssueRestController(IssueReportRepository issueReportRepository) {
        this.issueReportRepository = issueReportRepository;
    }

    @GetMapping
    public List<IssueReport> getIssues() {
        return this.issueReportRepository.findAllButPrivate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") Optional<IssueReport> issueReportOptional) {
        if (!issueReportOptional.isPresent() ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(issueReportOptional.get(), HttpStatus.OK);
    }
}