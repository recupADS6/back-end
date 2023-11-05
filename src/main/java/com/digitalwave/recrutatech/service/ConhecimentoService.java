package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.interfaces.IConhecimentoService;
import com.digitalwave.recrutatech.repository.ConhecimentoRepository;

import jakarta.persistence.EntityNotFoundException;

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
            throw new IllegalArgumentException("Conhecimento não encontrado!");
        }
        return cOp.get();
    }
    
    @Override
    public Conhecimento updateConhecimento(Long id, Conhecimento updateConhecimento) {
        Optional<Conhecimento> cOp = cRepo.findById(id);

        if (cOp.isPresent()) {
        	Conhecimento existingConhecimento = cOp.get();

            if (!ObjectUtils.isEmpty(updateConhecimento.getContent())) {
            	existingConhecimento.setContent(updateConhecimento.getContent());
            }

            return cRepo.save(existingConhecimento);
        } else {
            throw new EntityNotFoundException("Conhecimento não encontrado - ID: " + id);
        }
    }
    
	public void deleteConhecimento(Long id) {
		cRepo.deleteById(id);
	}

}
