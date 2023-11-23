package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Job;

public interface IJobService {
	
	public Job newJob(Job job);
	
	public List<Job> findAllJobs();
	
	public Job findJobId (Long id);
	
	public List<Job> findAllJobStatus (String jobStatus);
	
  public Job updateJob(Long id, Job updatedJob);
  
  void deleteJob(Long id);

}
