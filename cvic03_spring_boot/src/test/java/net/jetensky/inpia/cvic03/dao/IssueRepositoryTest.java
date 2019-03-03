package net.jetensky.inpia.cvic03.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void test() {
        Assert.assertEquals(issueRepository.findAll().size(), 0);
        issueRepository.save(new IssueReport());
        Assert.assertEquals(issueRepository.findAll().size(), 1);
    }
}