package net.jetensky.inpia.cvic03.controller;

import net.jetensky.inpia.cvic03.dao.IssueReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(IssueController.class)
public class IssueControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private IssueReportRepository issueReportRepository;

    @Test
    public void loginTest() throws Exception {
        mvc.perform(get("/issues"))
            .andExpect(status().isOk())
            .andExpect(view().name("issues/issuereport_list"));
    }
}