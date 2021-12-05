package controllers;

import data.ColorRepository;
import data.HeightRepository;
import data.MonthRepository;
import data.PlantRepository;
import model.Plant;
import model.PlantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

import java.util.HashMap;

@Controller
@RequestMapping(value="list")
public class ListController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private HeightRepository heightRepository;

    @Autowired
    private MonthRepository monthRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("month", "Month");
        columnChoices.put("color", "Color");
        columnChoices.put("height", "Height");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("colors", colorRepository.findAll());
        model.addAttribute("height", heightRepository.findAll());
        model.addAttribute("month", monthRepository.findAll());

        return "list";
    }

    @RequestMapping(value = "plants")
    public String listPlantsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Plant> plants;
        if (column.toLowerCase().equals("all")){
            plants = plantRepository.findAll();
            model.addAttribute("title", "All Plants");
        } else {
            plants = PlantData.findByColumnAndValue(column, value, plantRepository.findAll());
            model.addAttribute("title", "Plants with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("plants", plants);

        return "list-plants";
    }
}
