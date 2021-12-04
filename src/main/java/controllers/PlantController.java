package controllers;

import data.ColorRepository;
import data.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlantController {
    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private ColorRepository colorRepository;


}
