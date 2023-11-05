package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Habilidade;
import com.digitalwave.recrutatech.interfaces.IHabilidadeService;
import com.digitalwave.recrutatech.repository.HabilidadeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
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
            throw new IllegalArgumentException("Habilidade não encontrada!");
        }
        return hOp.get();
    }
    
    @Override
    public Habilidade updateHabilidade(Long id, Habilidade updateHabilidade) {
        Optional<Habilidade> hOp = hRepo.findById(id);

        if (hOp.isPresent()) {
        	Habilidade existingHabilidade = hOp.get();

            if (!ObjectUtils.isEmpty(updateHabilidade.getContent())) {
            	existingHabilidade.setContent(updateHabilidade.getContent());
            }

            return hRepo.save(existingHabilidade);
        } else {
            throw new EntityNotFoundException("Habilidade não encontrada - ID: " + id);
        }
    }
    
	public void deleteHabilidade(Long id) {
		hRepo.deleteById(id);
	}

}
