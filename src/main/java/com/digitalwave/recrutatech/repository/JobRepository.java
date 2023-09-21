package com.digitalwave.recrutatech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalwave.recrutatech.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	public Optional<Job> findByJobTitle(String jobTitle);
	
	@Query("select j from Job j where j.jobTitle = ?1")
	public Optional<Job> buscarPorTitulo(String jobTitle);
	
	public Optional<Job> findByJobLevel(String jobLevel);
	
	@Query("select j from Job j where j.jobLevel = ?1")
	public Optional<Job> buscarPorNivel(String jobLevel);
	
	public Optional<Job> findByJobDescription(String jobDescription);
	
	@Query("select j from Job j where j.jobDescription = ?1")
	public Optional<Job> buscarPelaDescricao(String jobDescription);

	public List<Job> findAllByJobStatus(String jobStatus);

}
