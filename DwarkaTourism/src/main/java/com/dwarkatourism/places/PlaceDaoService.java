package com.dwarkatourism.places;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PlaceDaoService {

	private static List<Places> placeList= new ArrayList<>();
	
	private static int placeCounter= 3;
	
	static{
		placeList.add(new Places(1,"Gomti Ghat","Back side of the Dwarkadhis temple",new Date()));
		placeList.add(new Places(2,"Dwarkadhis Temple","Back side of the Dwarkadhis temple",new Date()));
		placeList.add(new Places(3,"Bhadkeshwar Mahadev Temple","Back side of the Dwarkadhis temple",new Date()));
	}
	
	// find all the places
	public List<Places> findAll(){
		return placeList;
	}
	
	// save new placeList
	public Places save(Places data){
		if(data.getId()== null){
			data.setId(++placeCounter);
		}
		placeList.add(data);
		return data;
	}
	
	// Find one data 
	public Places findOne(String name){
		for(Places data: placeList){
			if(data.getName().equals(name))
				return data;
		}
		return null;
	}
	
	//Delete placeList from the List
	public Places deleteById(int id){
		Iterator<Places> place= placeList.iterator(); 
		
		while(place.hasNext()){
			Places data= place.next();
			if(data.getId()==id){
				place.remove();
				return data;
			}
		}
		return null;
	}
	
}
