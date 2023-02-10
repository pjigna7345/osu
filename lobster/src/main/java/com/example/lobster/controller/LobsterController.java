package com.example.lobster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lobster.model.Lobster;
import com.example.lobster.services.LobsterService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LobsterController {
	@Autowired
	LobsterService lobsterService;

	final static Logger logger = LoggerFactory.getLogger(LobsterController.class);

	@PostMapping("/lobster")
	Lobster create(@RequestBody Lobster lobster) {
		return lobsterService.save(lobster);
	}

	@GetMapping("/lobster")
	Iterable<Lobster> read() {
		return lobsterService.findAll();
	}

	@PutMapping("/lobster")
	Lobster update(@RequestBody Lobster lobster) {
		return lobsterService.save(lobster);
	}

	@DeleteMapping("/lobster/{id}")
	void delete(@PathVariable Integer id) {
		lobsterService.deleteById(id);
	}

}
