package com.digitalwave.recrutatech.interfaces;

import java.util.List;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.interfaces.IConhecimentoService;

public interface IConhecimentoService {
	public Conhecimento newConhecimento(Conhecimento conhecimento);
	
	public List<Conhecimento> findAllConhecimento();
	
	public Conhecimento findConhecimentoId (Long id);
	
    public Conhecimento updateConhecimento(Long id, Conhecimento updatedConhecimento);
    
    void deleteConhecimento(Long id);

}
