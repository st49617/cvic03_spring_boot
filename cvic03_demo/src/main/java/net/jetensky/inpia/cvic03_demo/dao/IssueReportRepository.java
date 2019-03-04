package net.jetensky.inpia.cvic03_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IssueReportRepository extends
        JpaRepository<IssueReport, Long> {
    List<IssueReport> findByDescription(String description);
}
