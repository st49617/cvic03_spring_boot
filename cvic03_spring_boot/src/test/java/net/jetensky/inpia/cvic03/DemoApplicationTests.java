package net.jetensky.inpia.cvic03;

import net.jetensky.inpia.cvic03.Application;
import net.jetensky.inpia.cvic03.HelloWorldController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class DemoApplicationTests {

	@Autowired HelloWorldController helloWorldController;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(helloWorldController);
	}

}
