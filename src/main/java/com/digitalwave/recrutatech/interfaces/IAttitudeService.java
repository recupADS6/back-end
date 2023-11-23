package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Attitude;

public interface IAttitudeService {
	public Attitude newAttitude(Attitude attitude);
	
	public List<Attitude> findAllAttitude();
	
	public Attitude findAttitudeId (Long id);
	
  public Attitude updateAttitude(Long id, Attitude updatedAttitude);
  
  void deleteAttitude(Long id);

}
