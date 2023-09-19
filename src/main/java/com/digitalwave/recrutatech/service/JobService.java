package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.repository.JobRepository;

@Service
public class JobService implements IJobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Override
	public Job newJob(Job job) {
		return jobRepo.save(job);
	}

	public List<Job> findAllJobs(){
		return jobRepo.findAll();
	}
	
    public Job findJobId(Long id) {
        Optional<Job> jobOp = jobRepo.findById(id);
        if(jobOp.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada!");
        }
        return jobOp.get();
    }


}
