package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.interfaces.IAtitudeService;
import com.digitalwave.recrutatech.repository.AtitudeRepository;

public class AtitudeService implements IAtitudeService {
	
	@Autowired
	private AtitudeRepository aRepo;
	
	@Override
	public Atitude newAtitude(Atitude atitude) {
		return aRepo.save(atitude);
	}

	public List<Atitude> findAllAtitude(){
		return aRepo.findAll();
	}
	
    public Atitude findAtitudeId(Long id) {
        Optional<Atitude> aOp = aRepo.findById(id);
        if(aOp.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada!");
        }
        return aOp.get();
    }

}
