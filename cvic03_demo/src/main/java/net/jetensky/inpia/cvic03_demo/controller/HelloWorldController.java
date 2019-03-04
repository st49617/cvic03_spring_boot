package net.jetensky.inpia.cvic03_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "<html>" +
                "<head>" +
                "<link rel=\"stylesheet\" href=\"./stylesxxx.css\" />" +
                "</head>" +
                "<body>Hello world YYY</body></html>";
    }
}
