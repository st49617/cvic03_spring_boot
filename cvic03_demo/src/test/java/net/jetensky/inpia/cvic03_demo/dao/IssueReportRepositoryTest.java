package net.jetensky.inpia.cvic03_demo.dao;

import net.jetensky.inpia.cvic03_demo.controller.IssuesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueReportRepositoryTest {
    @Autowired
    IssueReportRepository issueReportRepository;

    @Autowired
    DataSource dataSource;

    @Test
    @Transactional
    public void testSave() {
        IssueReport report = new IssueReport();
        report.setDescription("test");
        report.setUrl("url");
        issueReportRepository.save(report);

        Long id = report.getId();
        assertNotNull(id);

        Optional<IssueReport> fromDb = issueReportRepository.findById(id);
        assertEquals(fromDb.get().getDescription(), "test");
    }

    @Test
    @Transactional
    public void testGetByDescription() {
        IssueReport report = new IssueReport();
        report.setDescription("test");
        report.setUrl("url");
        issueReportRepository.save(report);

        IssueReport report3 = new IssueReport();
        report3.setDescription("test");
        report3.setUrl("url");
        issueReportRepository.save(report3);

        IssueReport report2 = new IssueReport();
        report2.setDescription("test2");
        report2.setUrl("url2");
        issueReportRepository.save(report2);

        assertEquals(issueReportRepository.findByDescription("test").size(), 2);
        assertEquals(issueReportRepository.findByDescription("test2").size(), 1);
    }
}