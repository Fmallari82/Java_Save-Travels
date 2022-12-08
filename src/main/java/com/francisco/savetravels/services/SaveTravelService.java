package com.francisco.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francisco.savetravels.models.SaveTravel;
import com.francisco.savetravels.repositories.SaveTravelRepository;

@Service
public class SaveTravelService {
	// adding the saveTravel repository as a dependency
	private final SaveTravelRepository saveTravelRepo;

	public SaveTravelService(SaveTravelRepository saveTravelRepo) {
		this.saveTravelRepo = saveTravelRepo;
	}

	// returns all the SaveTravels
	public List<SaveTravel> getAll() {
		return saveTravelRepo.findAll();
	}

	// creates a saveTravel
	public SaveTravel create(SaveTravel saveTravel) {
		return saveTravelRepo.save(saveTravel);
	}

	// retrieves a saveTravel
	public SaveTravel findOne(Long id) {
		Optional<SaveTravel> optionalSaveTravel = saveTravelRepo.findById(id);
		if (optionalSaveTravel.isPresent()) {
			return optionalSaveTravel.get();
		} else {
			return null;
		}
	}
	public SaveTravel update(
			Long id, 
			String expenseName, 
			String vendor, 
			String amount, 
			String description) {
		SaveTravel saveTravelToBeUpdated = new SaveTravel(
				id, 
				expenseName, 
				vendor, 
				amount, 
				description);
		return saveTravelRepo.save(saveTravelToBeUpdated);
	}
	public SaveTravel update(SaveTravel saveTravel) {
		return saveTravelRepo.save(saveTravel);
	}
	
	public String deleteByID(Long id) {
		saveTravelRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}

	public Object searchSaveTravel(String search) {
		return saveTravelRepo.findByExpenseNameContaining(search);
}
}
