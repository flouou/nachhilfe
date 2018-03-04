package com.bindschaedel.nachhilfe.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bindschaedel.nachhilfe.entities.Entry;

public interface EntryRepository extends CrudRepository<Entry, Integer>{
	
	@Query("select sum(cost) from Entry where name=?1")
	double getTotalCost(String name);
	
	@Query("select sum(given) from Entry where name=?1")
	double getTotalGiven(String name);
	
	@Query("select sum(cost) from Entry")
	double getTotalCostOverall();
	
	@Query("select sum(given) from Entry")
	double getTotalGivenOverall();
}
