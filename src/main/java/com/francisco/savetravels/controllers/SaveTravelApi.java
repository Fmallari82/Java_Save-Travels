package com.francisco.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.savetravels.models.SaveTravel;
import com.francisco.savetravels.services.SaveTravelService;

@RestController
@RequestMapping("/api")
public class SaveTravelApi {

	private final SaveTravelService saveTravelServ;

	public SaveTravelApi(SaveTravelService saveTravelServ) {
		this.saveTravelServ = saveTravelServ;
	}

	// Create
	@PostMapping("/savetravels")
	public SaveTravel createDonation(
			@RequestParam("expenseName") String expenseName, 
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") String amount, 
			@RequestParam("description") String description) {
		SaveTravel newSaveTravel = new SaveTravel(
				expenseName, 
				vendor, 
				amount, 
				description);
		return saveTravelServ.create(newSaveTravel);
	}

	// Read All
	@GetMapping("/savetravels")
	public List<SaveTravel> findAllSaveTravels() {
		return saveTravelServ.getAll();
	}

	// Read one
	@GetMapping("/savetravels/{id}")
	public SaveTravel findOneSaveTravel(@PathVariable("id") Long id) {
		return saveTravelServ.findOne(id);
	}

	//Update one
	@PutMapping("/savetravels/{id}")
	public SaveTravel findOneAndUpdate(
        @PathVariable("id") Long id, 
        @RequestParam("expenseName") String expenseName,
        @RequestParam("vendor") String vendor, 
        @RequestParam("amount") String amount,
        @RequestParam("description") String description) {
		return saveTravelServ.update(
				id, 
				expenseName, 
				vendor, 
				amount, 
				description);
	}

	//Delete 
	@DeleteMapping("/savetravels/{id}")
	public void destroy(@PathVariable("id") Long id) {
		saveTravelServ.deleteByID(id);
	}
}
