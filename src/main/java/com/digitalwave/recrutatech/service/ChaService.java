package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.entity.Cha;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Habilidade;
import com.digitalwave.recrutatech.interfaces.IChaService;
import com.digitalwave.recrutatech.repository.AtitudeRepository;
import com.digitalwave.recrutatech.repository.ChaRepository;
import com.digitalwave.recrutatech.repository.ConhecimentoRepository;
import com.digitalwave.recrutatech.repository.HabilidadeRepository;

@Service
public class ChaService implements IChaService {
    @Autowired
    private ChaRepository chaRepo;
    @Autowired
    private ConhecimentoRepository cRepo;
    @Autowired
    private HabilidadeRepository hRepo;
    @Autowired
    private AtitudeRepository aRepo;


    
    public Cha createCha(Conhecimento conhecimento, Habilidade habilidade, Atitude atitude) {
        Cha cha = new Cha();
        cha.setConhecimento(conhecimento);
        cha.setHabilidade(habilidade);
        cha.setAtitude(atitude);
        return chaRepo.save(cha);
    }
    
    @Override
    public Cha newCha(Cha cha) {
        Long conhecimentoId = cha.getConhecimento().getId();
        Conhecimento conhecimento = cRepo.findById(conhecimentoId)
                .orElseThrow();
        cha.setConhecimento(conhecimento);
        
        Long habilidadeId = cha.getHabilidade().getId();
        Habilidade habilidade = hRepo.findById(habilidadeId)
                .orElseThrow();
        cha.setHabilidade(habilidade);
        
        Long atitudeId = cha.getAtitude().getId();
        Atitude atitude = aRepo.findById(atitudeId)
                .orElseThrow();
        cha.setAtitude(atitude);
        
        return chaRepo.save(cha);
    }

	public List<Cha> findAllCha(){
		return chaRepo.findAll();
	}
	
    public Cha findChaId(Long id) {
        Optional<Cha> chaOp = chaRepo.findById(id);
        if(chaOp.isEmpty()) {
            throw new IllegalArgumentException("CHA não encontrado!");
        }
        return chaOp.get();
    }



}
