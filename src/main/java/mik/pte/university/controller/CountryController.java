package mik.pte.university.controller;

import mik.pte.university.domain.Country;
import mik.pte.university.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

//    @GetMapping("/")
//    String home(Model model){
//        return  "country";
//    }


    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    String getCountry(Model model){
        model.addAttribute("country", countryService.findAll());
        return "country";
    }


}
