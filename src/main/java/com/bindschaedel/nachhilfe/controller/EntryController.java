package com.bindschaedel.nachhilfe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bindschaedel.nachhilfe.entities.Entry;
import com.bindschaedel.nachhilfe.services.EntryService;

@Controller
public class EntryController {
	
	@Autowired
	private EntryService entryService;

	@PostMapping("/create")
	public String create(@RequestParam(value="name") String name
			, @RequestParam(value="date") String date
			, @RequestParam(value="cost") double cost
			, @RequestParam(value="given") double given
			, Map<String, Iterable<Entry>> model) {
		
		model.put("entries", entryService.create(name, date, cost, given));
		return "all-entries";
	}
	
	@GetMapping("/all")
	public String getAllEntries(Map<String, Object> model){
		model.put("entries", entryService.getAllEntries());
		return "all-entries";
	}
	
	@GetMapping("/getEntry")
	public Entry getEntryById(@RequestParam(value="id") int id){
		return entryService.getEntryById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> deleteEntry(@RequestParam(value="id") int id) {
		entryService.delete(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public Entry editEntry(@RequestParam(value="id") int id
			,@RequestParam(value="name") String name
			,@RequestParam(value="date") String date
			,@RequestParam(value="cost") double cost
			,@RequestParam(value="given") double given) {
		
		return entryService.editEntry(id,name,date,cost,given);
	}
	
	@GetMapping("/allCosts")
	public double getCosts(@RequestParam(value="name") String name) {
		return entryService.getCosts(name);
	}
	
	@GetMapping("allGiven")
	public double getGiven(@RequestParam(value="name") String name) {
		return entryService.getGiven(name);
	}
	
}
