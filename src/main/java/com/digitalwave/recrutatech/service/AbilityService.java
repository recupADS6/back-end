package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.interfaces.IAbilityService;
import com.digitalwave.recrutatech.repository.AbilityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AbilityService implements IAbilityService {
	
	@Autowired
	private AbilityRepository hRepo;
	
	@Override
	public Ability newAbility(Ability ability) {
		return hRepo.save(ability);
	}

	public List<Ability> findAllAbility(){
		return hRepo.findAll();
	}
	
  public Ability findAbilityId(Long id) {
    Optional<Ability> hOp = hRepo.findById(id);
    if(hOp.isEmpty()) {
        throw new IllegalArgumentException("Ability não encontrada!");
    }
    return hOp.get();
  }
  
  @Override
  public Ability updateAbility(Long id, Ability updateAbility) {
    Optional<Ability> hOp = hRepo.findById(id);

    if (hOp.isPresent()) {
      Ability existingAbility = hOp.get();

      if (!ObjectUtils.isEmpty(updateAbility.getContent())) {
        existingAbility.setContent(updateAbility.getContent());
      }

      return hRepo.save(existingAbility);
    } else {
      throw new EntityNotFoundException("Ability não encontrada - ID: " + id);
    }
  }
  
	public void deleteAbility(Long id) {
		hRepo.deleteById(id);
	}

}
