package com.digitalwave.recrutatech.service;

import java.util.List;

import com.digitalwave.recrutatech.entity.Job;

public interface IJobService {
	
	public Job newJob(Job job);
	
	public List<Job> findAllJobs();
	
	public Job findJobId (Long id);

}
