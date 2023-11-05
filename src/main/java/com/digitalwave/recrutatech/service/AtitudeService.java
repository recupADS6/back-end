package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.interfaces.IAtitudeService;
import com.digitalwave.recrutatech.repository.AtitudeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
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
            throw new IllegalArgumentException("Atitude não encontrada!");
        }
        return aOp.get();
    }
    
    @Override
    public Atitude updateAtitude(Long id, Atitude updateAtitude) {
        Optional<Atitude> aOp = aRepo.findById(id);

        if (aOp.isPresent()) {
        	Atitude existingAtitude = aOp.get();

            if (!ObjectUtils.isEmpty(updateAtitude.getContent())) {
            	existingAtitude.setContent(updateAtitude.getContent());
            }

            return aRepo.save(existingAtitude);
        } else {
            throw new EntityNotFoundException("Atitude não encontrada - ID: " + id);
        }
    }
    
	public void deleteAtitude(Long id) {
		aRepo.deleteById(id);
	}

}
