package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalwave.recrutatech.Interfaces.IConhecimentoService;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.repository.ConhecimentoRepository;

@Service
public class ConhecimentoService implements IConhecimentoService {
	
	@Autowired
	private ConhecimentoRepository cRepo;
	
	@Override
	public Conhecimento newConhecimento(Conhecimento conhecimento) {
		return cRepo.save(conhecimento);
	}

	public List<Conhecimento> findAllConhecimento(){
		return cRepo.findAll();
	}
	
    public Conhecimento findConhecimentoId(Long id) {
        Optional<Conhecimento> cOp = cRepo.findById(id);
        if(cOp.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada!");
        }
        return cOp.get();
    }

}
