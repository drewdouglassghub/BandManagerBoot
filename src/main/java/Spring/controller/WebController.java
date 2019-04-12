package Spring.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Spring.beans.Venue;
import Spring.repository.VenueRepository;


@Controller
public class WebController {
	@Autowired
	VenueRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllVenues(Model model) {
		model.addAttribute("venues", repo.findAll());
		return "viewVenues";
	}
	
	
	@GetMapping("/addVenue")
	public String addNewVenue(Model model) {
	    Venue v = new Venue();
	    model.addAttribute("newVenue", v);
	    return "addVenue";
	}
	
	@PostMapping("/addVenue")
	public String addNewVenue(@ModelAttribute Venue v, Model model) {
		repo.save(v);
		model.addAttribute("venues", repo.findAll());
		return "viewVenues";
	}
	
	@GetMapping("/edit/{venueid}")
	public String showUpdateForm(@PathVariable("venueid") long venueid, Model model) {
	    Venue v = repo.findById(venueid)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + venueid));
	    repo.save(v);	    
	    model.addAttribute("membersince", v.getMembersince());
	    model.addAttribute("venue", v);
	    return "updateVenue";
	}

	
	@PostMapping("/update/{venueid}")
	public String updateUser(@PathVariable("venueid") long venueid, @Valid Venue v, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        v.setVenueid(venueid);
	        return "updateVenue";
	    }
	        
	    repo.save(v);
	    model.addAttribute("membersince", v.getMembersince());
	    model.addAttribute("venues", repo.findAll());
		return "viewVenues";
	}
	     
	@GetMapping("/delete/{venueid}")
	public String deleteUser(@PathVariable("venueid") long venueid, Model model) {
	    Venue v = repo.findById(venueid)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + venueid));
	    repo.delete(v);
	    model.addAttribute("venues", repo.findAll());
		return "viewVenues";
	}
	
}