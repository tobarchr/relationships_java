package com.codingdojo.ct.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.ct.models.License;
import com.codingdojo.ct.models.Person;
import com.codingdojo.ct.services.LicenseService;
import com.codingdojo.ct.services.PersonService;

@Controller
public class MainController {
	private final LicenseService licenseService;
	private final PersonService personService;
	public MainController(LicenseService licenseService,PersonService personService) {
		this.licenseService = licenseService;
		this.personService=personService;
	}
	
  @RequestMapping("/")
    public String index(Model model) {
        List<License> licenses = licenseService.allLicenses();
        List<Person> people = personService.allPeople();
        model.addAttribute("licenses",licenses);
        model.addAttribute("people",people);
        return "index.jsp";
    }
  
  @RequestMapping("persons/new")
  	public String newPerson(Model model) {
		model.addAttribute("person",new Person());
		return "/persons/new.jsp";
  }
  
  @RequestMapping(value="/persons", method=RequestMethod.POST)
  public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
      if (result.hasErrors()) {
          return "/persons/new.jsp";
      } else {
    	  personService.createPerson(person);
          return "redirect:/";
      }
  }
  
  @RequestMapping("licenses/new")
	public String newLicense(Model model) {
      List<Person> personList = personService.allPeople();
      model.addAttribute("person",personList);
      model.addAttribute("license",new License());
      return "/licenses/new.jsp";
}
  
  @RequestMapping(value="/licenses", method=RequestMethod.POST)
  public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
      if (result.hasErrors()) {
          return "/licenses/new.jsp";
      } else {
    	  licenseService.createLicense(license);
          return "redirect:/";
      }
  }
  
}
