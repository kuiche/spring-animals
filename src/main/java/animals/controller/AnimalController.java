package animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sam on 2015-10-27.
 */
@Controller
public class AnimalController {

    @RequestMapping("/animals")
    public String index() {
        return "animals.list";
    }
}
