package com.francisco.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.francisco.savetravels.models.SaveTravel;
import com.francisco.savetravels.services.SaveTravelService;

@Controller
@RequestMapping("/savetravels")
public class SaveTravelController {
	
	public final SaveTravelService saveTravelServ;
	public SaveTravelController(SaveTravelService saveTravelServ) {
		this.saveTravelServ = saveTravelServ;
	}
	
	@GetMapping("/all")
	public String allSaveTravels(@ModelAttribute("saveTravel") SaveTravel saveTravel, Model model) {
		model.addAttribute("allSaveTravels", saveTravelServ.getAll());
		model.addAttribute("saveTravel", new SaveTravel());
		return "index.jsp";
	}

	@GetMapping("expenses/{id}")
	public String oneSaveTravel(@PathVariable("id") Long id, Model model) {
		SaveTravel oneSaveTravel = saveTravelServ.findOne(id);
		model.addAttribute("oneSaveTravel", oneSaveTravel );
		return "showOne.jsp";
	}
	@GetMapping("/search")
	public String searchSaveTravel(@RequestParam("search") String Search, Model model) {
		model.addAttribute("allSaveTravels", saveTravelServ.searchSaveTravel(Search));
		model.addAttribute("donation", new SaveTravel());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newSaveTravel(@ModelAttribute("saveTravel") SaveTravel saveTravel) {
		
		return "index.jsp";
	}
	
	@PostMapping("/all")
	public String processSaveTravel(
			@Valid 
			@ModelAttribute("saveTravel")
			SaveTravel saveTravel, 
			BindingResult result,
			Model model) 
	{	
		if(result.hasErrors()) {
			model.addAttribute("allSaveTravels", saveTravelServ.getAll());
			return "index.jsp";
		}
		saveTravelServ.create(saveTravel);
		return "redirect:/savetravels/all";
	
		}
	@GetMapping("/edit/{id}")
		public String editSaveTravel (
				@PathVariable("id") Long id, Model model) {
			SaveTravel saveTravelToBeEdited = saveTravelServ.findOne(id);
			model.addAttribute("saveTravel", saveTravelToBeEdited);
			return "edit.jsp";
		}

	@PutMapping("/edit/process/{id}")
	public String processEditSaveTravel(
			@Valid 
			@ModelAttribute("saveTravel")
			SaveTravel saveTravel, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		saveTravelServ.update(saveTravel);
		return "redirect:/savetravels/all";
	
}
	@DeleteMapping("/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		saveTravelServ.deleteByID(id);
		return "redirect:/savetravels/all";
	}
}


