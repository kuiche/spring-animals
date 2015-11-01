package animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sam on 2015-10-26.
 *
 * Basic controller for the home page
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
