package com.digitalwave.recrutatech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalwave.recrutatech.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	public Optional<Job> findByTitle(String title);
	
	@Query("select j from Job j where j.title = ?1")
	public Optional<Job> buscarPorTitulo(String title);
	
	public Optional<Job> findByLevel(String level);
	
	@Query("select j from Job j where j.level = ?1")
	public Optional<Job> buscarPorNivel(String level);
	
	public Optional<Job> findByDescription(String description);
	
	@Query("select j from Job j where j.description = ?1")
	public Optional<Job> buscarPelaDescricao(String description);
}
