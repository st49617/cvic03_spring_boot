package net.jetensky.inpia.cvic03.application;

import net.jetensky.inpia.cvic03.dao.IssueReport;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOAspect {

	@Before(value = "execution(* net.jetensky.inpia.cvic03.dao.IssueReportRepository.*(..)) and args(issueReport)")
	public void beforeAdvice(JoinPoint joinPoint, IssueReport issueReport) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Creating IssueReport with description - " + issueReport.getDescription());
	}

	@After(value = "execution(* net.jetensky.inpia.cvic03.dao.IssueReportRepository.*(..)) and args(issueReport)")
	public void afterAdvice(JoinPoint joinPoint, IssueReport issueReport) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created IssueReport with description - " + issueReport.getDescription());
	}
}