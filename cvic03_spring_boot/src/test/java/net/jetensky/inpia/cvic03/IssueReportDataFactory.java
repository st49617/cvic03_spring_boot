package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.cvic03.dao.IssueReport;
import net.jetensky.inpia.cvic03.dao.IssueReportRepository;
import net.jetensky.inpia.cvic03.dao.User;
import net.jetensky.inpia.cvic03.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueReportDataFactory {

    @Autowired Creator creator;

    @Autowired
    private IssueReportRepository issueReportRepository;

    @Autowired
    UserRepository userRepository;

    public void saveIssueReport() {
        saveIssueReport("test@email.cz");
    }

    public void saveIssueReport(String email) {
        //User user = saveUser();
        User user = (User) creator.saveEntity(new User());

        IssueReport entity = new IssueReport();
        entity.setEmail(email);
        entity.setUser(user);
        issueReportRepository.save(entity);
    }

    private User saveUser() {
        return saveUser(null);
    }
    private User saveUser(String surname) {
        User user = new User();
        user.setFirstname("Pavel");
        if (surname!=null) user.setSurname(surname);
        else user.setSurname("Jetenský");

        userRepository.save(user);
        return user;
    }


}
