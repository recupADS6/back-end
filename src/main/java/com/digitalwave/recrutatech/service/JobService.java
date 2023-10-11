package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.interfaces.IJobService;
import com.digitalwave.recrutatech.repository.JobRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JobService implements IJobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private ConhecimentoRepository cRepo;
	
    @Override
    public Job newJob(Job job) {
        Long conhecimentoId = job.getConhecimento().getId();
        Conhecimento conhecimento = cRepo.findById(conhecimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Conhecimento não encontrado com o ID: " + conhecimentoId));
        job.setConhecimento(conhecimento);
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

    public List<Job> findAllJobStatus(String jobStatus) {
        return jobRepo.findAllByJobStatus(jobStatus);
    }
    @Override
    public Job updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOp = jobRepo.findById(id);

        if (jobOp.isPresent()) {
            Job existingJob = jobOp.get();

            // Atualiza os campos apenas se estiverem presentes no JSON
            if (!ObjectUtils.isEmpty(updatedJob.getJobTitle())) {
                existingJob.setJobTitle(updatedJob.getJobTitle());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobLevel())) {
                existingJob.setJobLevel(updatedJob.getJobLevel());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobDescription())) {
                existingJob.setJobDescription(updatedJob.getJobDescription());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobStatus())) {
                existingJob.setJobStatus(updatedJob.getJobStatus());
            }

            if (updatedJob.getConhecimento() != null) {
                existingJob.setConhecimento(updatedJob.getConhecimento());
            }

            return jobRepo.save(existingJob);
        } else {
            throw new EntityNotFoundException("Vaga não encontrada - ID: " + id);
        }
    }
        
	public void deleteJob(Long id) {
		jobRepo.deleteById(id);
	}

}
