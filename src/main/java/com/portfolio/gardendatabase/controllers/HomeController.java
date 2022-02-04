package com.portfolio.gardendatabase.controllers;


import com.portfolio.gardendatabase.models.Color;
import com.portfolio.gardendatabase.models.Month;
import com.portfolio.gardendatabase.models.Plant;
import com.portfolio.gardendatabase.data.ColorRepository;
import com.portfolio.gardendatabase.data.HeightRepository;
import com.portfolio.gardendatabase.data.MonthRepository;
import com.portfolio.gardendatabase.data.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private HeightRepository heightRepository;

    @Autowired
    private MonthRepository monthRepository;

    private List <Plant> Plants;
    private List <Color> Colors;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Plants");

        return "index";
    }

    @GetMapping("add")
    public String displayAddPlantForm(Model model) {
        model.addAttribute(new Plant());
        model.addAttribute("color", colorRepository.findAll());
        model.addAttribute("month", monthRepository.findAll());
        model.addAttribute("height", heightRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddPlantForm(@ModelAttribute @Valid Plant newPlant,
                                      Errors errors, Model model, @RequestParam int monthId, @RequestParam List<Integer> colors) {



        if (errors.hasErrors()) {

            return "add";
        }
        List<Color> colorObjs = (List<Color>) colorRepository.findAllById(colors);
        newPlant.setColors(colorObjs);

        Month month = monthRepository.findById(monthId).orElse(new Month());
        newPlant.setMonth(month);


        return "redirect";



    }

    @GetMapping("view/{plantId}")
    public String displayViewPlant(Model model, @PathVariable int plantId) {
//     extends CrudRepository<Color, Integer>
        return "view";
    }


}
