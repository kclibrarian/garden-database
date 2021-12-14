package com.portfolio.gardendatabase.controllers;

import com.portfolio.gardendatabase.data.HeightRepository;
import com.portfolio.gardendatabase.models.Height;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("height")
public class HeightController {
//    @Autowired
//    private HeightController heightController;

    @Autowired
    private HeightRepository heightRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("height", heightRepository.findAll());
        return "height/index";
    }

    @GetMapping("add")
    public String displayAddHeightForm(Model model) {
        model.addAttribute(new Height());
        return "height/add";
    }

    @PostMapping("add")
    public String processAddHeightForm(@ModelAttribute @Valid Height newHeight,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "height/add";
        }
        heightRepository.save(newHeight);
        model.addAttribute("height", heightRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{heightId}")
    public String displayViewHeight(Model model, @PathVariable int heightId) {

        Optional optHeight = heightRepository.findById(heightId);
        if (optHeight.isPresent()) {
            Height height = (Height) optHeight.get();
            model.addAttribute("height", height);
            return "height/view";
        } else {
            return "redirect:../";
        }
    }
}
