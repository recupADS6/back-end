package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Atitude;

public interface IAtitudeService {
	public Atitude newAtitude(Atitude atitude);
	
	public List<Atitude> findAllAtitude();
	
	public Atitude findAtitudeId (Long id);
	
    public Atitude updateAtitude(Long id, Atitude updatedAtitude);
    
    void deleteAtitude(Long id);

}
