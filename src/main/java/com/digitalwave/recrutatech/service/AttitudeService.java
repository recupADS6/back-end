package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.interfaces.IAttitudeService;
import com.digitalwave.recrutatech.repository.AttitudeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttitudeService implements IAttitudeService {
	
	@Autowired
	private AttitudeRepository aRepo;
	
	@Override
	public Attitude newAttitude(Attitude attitude) {
		return aRepo.save(attitude);
	}

	public List<Attitude> findAllAttitude(){
		return aRepo.findAll();
	}
	
  public Attitude findAttitudeId(Long id) {
    Optional<Attitude> aOp = aRepo.findById(id);
    if(aOp.isEmpty()) {
      throw new IllegalArgumentException("Attitude não encontrada!");
    }
    return aOp.get();
  }
  
  @Override
  public Attitude updateAttitude(Long id, Attitude updateAttitude) {
    Optional<Attitude> aOp = aRepo.findById(id);

    if (aOp.isPresent()) {
      Attitude existingAttitude = aOp.get();

      if (!ObjectUtils.isEmpty(updateAttitude.getContent())) {
        existingAttitude.setContent(updateAttitude.getContent());
      }

        return aRepo.save(existingAttitude);
    } else {
      throw new EntityNotFoundException("Attitude não encontrada - ID: " + id);
    }
  }
    
	public void deleteAttitude(Long id) {
		aRepo.deleteById(id);
	}

}
