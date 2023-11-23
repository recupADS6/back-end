package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Ability;

public interface IAbilityService {
	public Ability newAbility(Ability ability);
	
	public List<Ability> findAllAbility();
	
	public Ability findAbilityId (Long id);
	
  public Ability updateAbility(Long id, Ability updatedAbility);
  
  void deleteAbility(Long id);

}
