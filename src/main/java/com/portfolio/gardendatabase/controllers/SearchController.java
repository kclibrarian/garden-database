package com.portfolio.gardendatabase.controllers;

import com.portfolio.gardendatabase.data.PlantRepository;
import com.portfolio.gardendatabase.models.Plant;
import com.portfolio.gardendatabase.models.PlantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PlantRepository plantRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
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
        model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("title", "Plants with " + ListController.columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("plants", plants);

        return "search";
    }
}