package com.portfolio.gardendatabase.controllers;

import com.portfolio.gardendatabase.data.ColorRepository;
import com.portfolio.gardendatabase.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("color")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("colors", colorRepository.findAll());
        return "colors/index";
    }

    @GetMapping("add")
    public String displayAddColorForm(Model model) {
        model.addAttribute(new Color());
        return "colors/add";
    }

    @PostMapping("add")
    public String processAddColorForm(@ModelAttribute @Valid Color newColor,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "colors/add";
        }
        colorRepository.save(newColor);
        model.addAttribute("colors", colorRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{colorId}")
    public String displayViewColor(Model model, @PathVariable int colorId) {

        Optional optColor = colorRepository.findById(colorId);
        if (optColor.isPresent()) {
            Color color = (Color) optColor.get();
            model.addAttribute("color", color);
            return "colors/view";
        } else {
            return "redirect:../";
        }
    }
}
