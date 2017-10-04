package com.dwarkatourism.places;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PlacesController {
	
	@Autowired
	PlaceDaoService placeService;
	
	// Find all the places
	@GetMapping("/places/allplace")
	public List<Places> findAllPlaces(){
		return placeService.findAll();
	}
	
	// Find one element
	@GetMapping("/places/findplace/{name}")
	public Places findOnePlace(@PathVariable String name) throws UserNotFoundException{
		
		Places place=placeService.findOne(name);
		if(place==null)
			throw new UserNotFoundException("Name : "+name);
		
		return place;
	}
	
	//Delete place with specific id
	@DeleteMapping("/places/deleteplace/{id}")
	public Places deletePlace(@PathVariable int id){
		Places place=placeService.deleteById(id);
		if(place==null)
			throw new UserNotFoundException("Id : "+id);
		return place;
	}
	
	
	//Creating new place with get
	@GetMapping("/places/addnewplace/{name}")
	public Places addPlace(@PathVariable String name){
		return placeService.save(new Places(null,name,"Good place",new Date()));
	}
	
	//Creating new Place and returning Uri of created resource(new place)
	@PostMapping("/places")
	public ResponseEntity<Object>  createPlaceEntry(@Valid @RequestBody Places place){
		Places savedPlace= placeService.save(place); 
		// Created 
		// /User/{id}     savedUser.getId()
		
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedPlace.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
