package com.portfolio.gardendatabase.controllers;


import com.portfolio.gardendatabase.data.ColorRepository;
import com.portfolio.gardendatabase.data.HeightRepository;
import com.portfolio.gardendatabase.data.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlantController {
    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private HeightRepository heightRepository;
}
