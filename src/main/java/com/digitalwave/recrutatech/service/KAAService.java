package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.KAA;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKAAService;
import com.digitalwave.recrutatech.repository.AbilityRepository;
import com.digitalwave.recrutatech.repository.AttitudeRepository;
import com.digitalwave.recrutatech.repository.KAARepository;
import com.digitalwave.recrutatech.repository.KnowledgeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class KAAService implements IKAAService {
  @Autowired
  private KAARepository kaaRepo;

  @Autowired
  private KnowledgeRepository cRepo;

  @Autowired
  private AbilityRepository hRepo;
  
  @Autowired
  private AttitudeRepository aRepo;

  public KAA createKAA(Knowledge knowledge, Ability ability, Attitude attitude) {
    KAA kaa = new KAA();
    kaa.setKnowledge(knowledge);
    kaa.setAbility(ability);
    kaa.setAttitude(attitude);
    return kaaRepo.save(kaa);
  }
  
  @Override
  public KAA newKAA(KAA kaa) {
    Long knowledgeId = kaa.getKnowledge().getId();
    Knowledge knowledge = cRepo.findById(knowledgeId)
            .orElseThrow();
    kaa.setKnowledge(knowledge);
    
    Long abilityId = kaa.getAbility().getId();
    Ability ability = hRepo.findById(abilityId)
            .orElseThrow();
    kaa.setAbility(ability);
    
    Long attitudeId = kaa.getAttitude().getId();
    Attitude attitude = aRepo.findById(attitudeId)
            .orElseThrow();
    kaa.setAttitude(attitude);
    
    return kaaRepo.save(kaa);
  }

public List<KAA> findAllKAA(){
  return kaaRepo.findAll();
}

  public KAA findKAAId(Long id) {
    Optional<KAA> kaaOp = kaaRepo.findById(id);
    
    if(kaaOp.isEmpty()) {
      throw new IllegalArgumentException("CHA não encontrado!");
    }

    return kaaOp.get();
  }
  
  @Override
  public KAA updateKAA(Long id, KAA updateKAA) {
    Optional<KAA> kaaOp = kaaRepo.findById(id);

    if (kaaOp.isPresent()) {
      KAA existingKAA = kaaOp.get();

      if (!ObjectUtils.isEmpty(updateKAA.getKnowledge())) {
        existingKAA.setKnowledge(updateKAA.getKnowledge());
      }
      if (!ObjectUtils.isEmpty(updateKAA.getAbility())) {
        existingKAA.setAbility(updateKAA.getAbility());
      }

      if (!ObjectUtils.isEmpty(updateKAA.getAttitude())) {
        existingKAA.setAttitude(updateKAA.getAttitude());
      }

        return kaaRepo.save(existingKAA);
    } else {
      throw new EntityNotFoundException("KAA não encontrado - ID: " + id);
    }
  }
    
	public void deleteKAA(Long id) {
		kaaRepo.deleteById(id);
	}

}
