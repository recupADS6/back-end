package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitalwave.recrutatech.entity.Habilidade;
import com.digitalwave.recrutatech.interfaces.IHabilidadeService;
import com.digitalwave.recrutatech.repository.HabilidadeRepository;

public class HabilidadeService implements IHabilidadeService {
	
	@Autowired
	private HabilidadeRepository hRepo;
	
	@Override
	public Habilidade newHabilidade(Habilidade habilidade) {
		return hRepo.save(habilidade);
	}

	public List<Habilidade> findAllHabilidade(){
		return hRepo.findAll();
	}
	
    public Habilidade findHabilidadeId(Long id) {
        Optional<Habilidade> hOp = hRepo.findById(id);
        if(hOp.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada!");
        }
        return hOp.get();
    }

}
