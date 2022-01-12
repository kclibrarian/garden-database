package com.portfolio.gardendatabase.controllers;

import com.portfolio.gardendatabase.models.data.ColorRepository;
import com.portfolio.gardendatabase.models.data.HeightRepository;
import com.portfolio.gardendatabase.models.data.MonthRepository;
import com.portfolio.gardendatabase.models.data.PlantRepository;
import com.portfolio.gardendatabase.models.Plant;
import com.portfolio.gardendatabase.models.PlantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        columnChoices.put("templates.month", "Month");
        columnChoices.put("color", "Color");
        columnChoices.put("height", "Height");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("color", colorRepository.findAll());
        model.addAttribute("height", heightRepository.findAll());
        model.addAttribute("templates.month", monthRepository.findAll());

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

    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }

    public static void setColumnChoices(HashMap<String, String> columnChoices) {
        ListController.columnChoices = columnChoices;
    }



}
