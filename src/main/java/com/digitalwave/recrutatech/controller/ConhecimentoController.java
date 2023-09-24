package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.service.IConhecimentoService;

@RestController
@RequestMapping(value="/cha")
@CrossOrigin

public class ConhecimentoController {
	@Autowired
	private IConhecimentoService service;
	
	@GetMapping("/")
	public List<Conhecimento> allConhecimento(){
		return service.findAllConhecimento();
	}
	
	@PostMapping("/add")
	public Conhecimento newConhecimento(@RequestBody Conhecimento conhecimento) {
		return service.newConhecimento(conhecimento);
	}

}
