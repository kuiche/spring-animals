package animals.controller;

import animals.entity.animal.Animal;
import animals.repository.AnimalRepository;
import animals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sam on 2015-10-27.
 */
@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @RequestMapping("/animals")
    public String index(Model model) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);

        return "animals.list";
    }
}
