package com.bindschaedel.nachhilfe.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bindschaedel.nachhilfe.DAO.Entry;
import com.bindschaedel.nachhilfe.repository.EntryRepository;

@RestController
public class EntryController {
	
	@Autowired
	private EntryRepository entryRepository;

	@PostMapping("/create")
	public Entry getEntryById(@RequestParam(value="name") String name
			, @RequestParam(value="date") String date
			, @RequestParam(value="cost") double cost
			, @RequestParam(value="given") double given) {
		
		Date entryDate = null;
		try {
			entryDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Entry entry = new Entry();
		entry.setName(name);
		entry.setDate(entryDate);
		entry.setCost(cost);
		entry.setGiven(given);
		entryRepository.save(entry);
		return entry;
	}
	
	@GetMapping("/all")
	public Iterable<Entry> getAllEntries(){
		return entryRepository.findAll();
	}
	
}
