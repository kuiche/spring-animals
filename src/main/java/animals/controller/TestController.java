package animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Created by Sam on 2015-10-26.
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
