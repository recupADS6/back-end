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
import com.digitalwave.recrutatech.entity.Cha;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Habilidade;
import com.digitalwave.recrutatech.interfaces.IChaService;

@RestController
@RequestMapping(value="/cha")
@CrossOrigin
public class ChaController {
	
	@Autowired
	private IChaService service;
	
	@GetMapping("/")
	public List<Cha> allCha(){
		return service.findAllCha();
	}
	
	@PostMapping("/add")
	public Cha createCha(@RequestBody Cha cha) {
	    Conhecimento conhecimento = cha.getConhecimento();
	    Habilidade habilidade = cha.getHabilidade();
	    Atitude atitude = cha.getAtitude();

	    return service.createCha(conhecimento, habilidade, atitude);
	}


}
