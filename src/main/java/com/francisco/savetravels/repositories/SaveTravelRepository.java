package com.francisco.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.francisco.savetravels.models.SaveTravel;

@Repository
public interface SaveTravelRepository extends CrudRepository<SaveTravel, Long> {
    // this method retrieves all the books from the database
    List<SaveTravel> findAll();
    // this method finds books with descriptions containing the search string
    List<SaveTravel> findByExpenseNameContaining(String search);
    // this method counts how many titles contain a certain string
//    Long countByVendorContaining(String search);
    // this method deletes a book that starts with a specific title
//    Long deleteByVendorStartingWith(String search);
}
