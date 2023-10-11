package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.interfaces.IAtitudeService;

@RestController
@RequestMapping(value="/ati")
@CrossOrigin
public class AtitudeController {
	
	@Autowired
	private IAtitudeService service;
	
	@GetMapping("/")
	public List<Atitude> allAtitude(){
		return service.findAllAtitude();
	}
	
	@PostMapping("/add")
	public Atitude newAtitude(@RequestBody Atitude atitude) {
		return service.newAtitude(atitude);
	}


}
