package net.jetensky.inpia.cvic03.dao;

import net.jetensky.inpia.cvic03.Creator;
import net.jetensky.inpia.cvic03.IssueReportDataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({IssueReportDataFactory.class, Creator.class})
@Transactional
public class IssueReportRepositoryTest {

    @Autowired
    IssueReportDataFactory issueReportDataFactory;

    @Autowired
    private IssueReportRepository issueReportRepository;

    @Test
    public void test() {
        Assert.assertEquals(issueReportRepository.findAll().size(), 0);
        issueReportRepository.save(new IssueReport());
        Assert.assertEquals(issueReportRepository.findAll().size(), 1);
    }

    @Test
    public void testFindAllByEmail() {

        issueReportDataFactory.saveIssueReport("e1");
        issueReportDataFactory.saveIssueReport("e2");
        issueReportDataFactory.saveIssueReport("e1");

        assertEquals(issueReportRepository.findAllByEmail("e1").size(), 2);
        assertEquals(issueReportRepository.findAllByEmail("e2").size(), 1);

    }


}