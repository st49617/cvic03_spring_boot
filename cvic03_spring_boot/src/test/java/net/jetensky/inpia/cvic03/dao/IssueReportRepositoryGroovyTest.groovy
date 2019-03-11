package net.jetensky.inpia.cvic03.dao;

import net.jetensky.inpia.cvic03.Creator
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional

import static junit.framework.TestCase.assertEquals
import static net.jetensky.inpia.cvic03.Creator.save
import static net.jetensky.inpia.cvic03.Creator.save1;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(Creator.class)
@Transactional
public class IssueReportRepositoryGroovyTest {

    @Autowired
    private IssueReportRepository issueReportRepository;

    @Autowired
    Creator creator;

    @Test
    public void testFindAllByEmail() {
        save(
                new IssueReport(email: "e1"),
                new IssueReport(
                email: "e2",
                user: save1(new User(surname: "Jetenský"))
        ))
        save(new IssueReport(email: "e1"));

        assertEquals(issueReportRepository.findAllByEmail("e1").size(), 2);
        def e2Issues = issueReportRepository.findAllByEmail("e2")
        assertEquals(e2Issues.size(), 1);

        assertEquals(e2Issues[0].user.surname,"Jetenský");

    }

    @Test
    public void testValidateIssueReportInvalidUrl() {

        creator.saveEntity(new IssueReport(url: "httpbla"));

        assertEquals(issueReportRepository.findAllByEmail("e1").size(), 2);
        assertEquals(issueReportRepository.findAllByEmail("e2").size(), 1);

    }


}