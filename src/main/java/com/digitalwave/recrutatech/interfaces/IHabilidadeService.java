package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Habilidade;

public interface IHabilidadeService {
	public Habilidade newHabilidade(Habilidade habilidade);
	
	public List<Habilidade> findAllHabilidade();
	
	public Habilidade findHabilidadeId (Long id);
	
    public Habilidade updateHabilidade(Long id, Habilidade updatedHabilidade);
    
    void deleteHabilidade(Long id);

}
