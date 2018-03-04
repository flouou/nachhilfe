package com.bindschaedel.nachhilfe.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bindschaedel.nachhilfe.entities.Entry;
import com.bindschaedel.nachhilfe.repositories.EntryRepository;
import com.bindschaedel.nachhilfe.util.DateFormatter;

@Service
public class EntryService {
	
	@Autowired
	private EntryRepository entryRepository;
	
	@Autowired
	private DateFormatter dateFormatter;
	
	public Iterable<Entry> create(String name, String date, double cost, double given) {
		Date entryDate = null;
		entryDate = dateFormatter.HTMLtoSQLDate(date);
		Entry entry = new Entry();
		entry.setName(name);
		entry.setDate(entryDate);
		entry.setCost(cost);
		entry.setGiven(given);
		entryRepository.save(entry);
		
		return entryRepository.findAll();
	}
	
	public Iterable<Entry> getAllEntries(){
		return entryRepository.findAll();
	}
	
	public Entry getEntryById(int id) {
		return entryRepository.findOne(id);
	}
	
	public void delete(int id) {
		entryRepository.delete(id);
	}
	
	public Entry editEntry(int id, String name, String date, double cost, double given) {
		Date entryDate = null;
		try {
			entryDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Entry entry = new Entry();
		entry.setId(id);
		entry.setName(name);
		entry.setDate(entryDate);
		entry.setCost(cost);
		entry.setGiven(given);
		entryRepository.save(entry);
		return entry;
	}
	
	public double getCosts(String name) {
		if(name != null) {
			return entryRepository.getTotalCost(name);
		}else {
			return entryRepository.getTotalCostOverall();
		}
		
	}
	
	public double getGiven(String name) {
		if(name != null) {
			return entryRepository.getTotalGiven(name);
		}
		return entryRepository.getTotalGivenOverall();
	}
}
