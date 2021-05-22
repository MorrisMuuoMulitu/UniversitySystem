package mik.pte.university.controller;

import mik.pte.university.domain.Country;
import mik.pte.university.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public String getCountry(Model model){
        model.addAttribute("country", countryService.findAll());
        return "/country";

    }
}
