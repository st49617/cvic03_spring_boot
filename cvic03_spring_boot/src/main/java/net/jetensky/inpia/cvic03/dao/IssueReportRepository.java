package net.jetensky.inpia.cvic03.dao;

import java.util.Collection;
import java.util.List;

import net.jetensky.inpia.cvic03.dao.IssueReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueReportRepository extends JpaRepository<IssueReport, Long> {
    @Query(value = "SELECT i FROM IssueReport i WHERE markedAsPrivate = false")
    List<IssueReport> findAllButPrivate();


    List<IssueReport> findAllByEmail(String email);
}
