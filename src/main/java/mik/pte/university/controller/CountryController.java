package mik.pte.university.controller;


import mik.pte.university.domain.Country;
import mik.pte.university.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
public class CountryController implements RestController<Country> {

    private final CountryService countryService;


    @Autowired
    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @GetMapping("/all")
    String getCountry(Model model){
        model.addAttribute("country",countryService.findAll());
        return "country";
    }


    @Override
    public String getAll(Model model) {
        model.addAttribute("country",countryService.findAll());
        return "country";
    }
}
