package com.digitalwave.recrutatech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalwave.recrutatech.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByUsername(String username);
}