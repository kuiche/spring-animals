package animals.controller;

import animals.entity.Produce;
import animals.entity.animal.Animal;
import animals.entity.animal.Cow;
import animals.exception.AnimalTypeNotFoundException;
import animals.repository.AnimalRepository;
import animals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sam on 2015-10-27.
 */
@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @ModelAttribute("produce")
    public Produce constructProduce() {
        return new Produce();
    }

    @RequestMapping(value="/animals", method=RequestMethod.GET)
    public String index(Model model) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);

        return "animals.list";
    }

    @RequestMapping(value="/animals", method=RequestMethod.POST)
    public String create(
            @RequestParam(value="name", required=true) String name,
            @RequestParam(value="type", required=true) String type,
            Model model) {

        try {
            animalService.createAnimal(type, name);
        } catch (AnimalTypeNotFoundException e) {
            e.printStackTrace();
        }

        // Redirect to list
        return "redirect:/animals.html";
    }

    @RequestMapping(value="/animals/{id}", method=RequestMethod.DELETE)
    public String create(
            @PathVariable(value="id") Integer id,
            Model model) {

        animalService.delete(id);

        // Redirect to list
        return "redirect:/animals.html";
    }

    @RequestMapping(value="/animals/{id}", method=RequestMethod.GET)
    public String show(
            @PathVariable(value="id") Integer id,
            Model model) {

        Animal animal = animalService.findOneWithProduce(id);
        model.addAttribute("animal", animal);

        // Redirect to list
        return "animals.show";
    }

    @RequestMapping(value="/animals/{id}/produce", method=RequestMethod.POST)
    public String addProduce(@PathVariable(value="id") Integer id, @ModelAttribute("produce") Produce produce, Model model) {
        produce.setAnimal(animalService.findOne(id));
        animalService.createProduce(produce);

        return "redirect:/animals/" + id.toString() + ".html";
    }
}
