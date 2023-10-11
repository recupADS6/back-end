package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.entity.Cha;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Habilidade;

public interface IChaService {
	public Cha newCha(Cha cha);

	public Cha createCha(Conhecimento conhecimento, Habilidade habilidade, Atitude atitude);
	
	public List<Cha> findAllCha();
	
	public Cha findChaId (Long id);

	

}
