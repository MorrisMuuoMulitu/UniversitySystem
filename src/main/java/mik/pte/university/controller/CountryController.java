package mik.pte.university.controller;

import mik.pte.university.domain.Country;
import mik.pte.university.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;


    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    String getCountry(Model model){
        model.addAttribute("country", countryService.findAll());
        return "country";
    }

    @GetMapping("/add")
    String addCountries(Model model){
        model.addAttribute("country", new Country());

        return "new-country";
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String postCountry(Model model, Country country){
        model.addAttribute("country", country);

        countryService.saveObject(country);
        return "redirect:/country/all";
    }

    @GetMapping("/edit/{country_id}")
    String editCountry(@PathVariable("country_id") String country_id, Model model){
        model.addAttribute("country", countryService.findById(Long.parseLong(country_id)));
        return "edit_country";
    }

    @PostMapping(value="/edit/{country_id}", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String postEditCountry(@PathVariable("country_id") String country_id, Model model, Country country){

        countryService.postEdit(Long.parseLong(country_id), country);
        model.addAttribute("country", countryService.findAll());
        return "redirect:/country/all";
    }

    @GetMapping("/delete/{country_id}")
    String deleteCountry(@PathVariable("country_id") String country_id, Model model){
        countryService.deleteById(Long.parseLong(country_id));
        model.addAttribute("country", countryService.findAll());
        return "redirect:/country/all";
    }

}
