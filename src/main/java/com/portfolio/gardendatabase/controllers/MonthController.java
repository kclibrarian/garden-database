package com.portfolio.gardendatabase.controllers;

import com.portfolio.gardendatabase.data.MonthRepository;
import com.portfolio.gardendatabase.models.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("templates.month")
public class MonthController {
    @Autowired
    private MonthController monthController;

    @Autowired
    private MonthRepository monthRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("month", monthRepository.findAll());
        return "month/index";
    }

    @GetMapping("add")
    public String displayAddMonthForm(Model model) {
        model.addAttribute(new Month());
        return "month/add";
    }

    @PostMapping("add")
    public String processAddMonthForm(@ModelAttribute @Valid Month newMonth,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "month/add";
        }
        monthRepository.save(newMonth);
        model.addAttribute("month", monthRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{monthId}")
    public String displayViewMonth(Model model, @PathVariable int monthId) {

        Optional optMonth = monthRepository.findById(monthId);
        if (optMonth.isPresent()) {
            Month month = (Month) optMonth.get();
            model.addAttribute("month", month);
            return "month/view";
        } else {
            return "redirect:../";
        }
    }
}
