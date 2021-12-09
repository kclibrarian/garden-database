package controllers;

import data.PlantRepository;
import model.Plant;
import model.PlantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static controllers.ListController.columnChoices;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PlantRepository plantRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Plant> plants;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            plants = plantRepository.findAll();
        } else {
            plants = PlantData.findByColumnAndValue(searchType, searchTerm, plantRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Plants with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("plants", plants);

        return "search";
    }
}