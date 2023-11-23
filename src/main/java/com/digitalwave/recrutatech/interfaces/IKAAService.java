package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.KAA;
import com.digitalwave.recrutatech.entity.Knowledge;

public interface IKAAService {
	public KAA newKAA(KAA kaa);

	public KAA createKAA(Knowledge knowledge, Ability ability, Attitude attitude);
	
	public List<KAA> findAllKAA();
	
	public KAA findKAAId (Long id);
	
	public KAA updateKAA(Long id, KAA updateKAA);
	
	void deleteKAA (Long id);

}
