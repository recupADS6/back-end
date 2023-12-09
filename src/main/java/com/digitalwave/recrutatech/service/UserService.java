package com.digitalwave.recrutatech.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import com.digitalwave.recrutatech.entity.Usuario;
import com.digitalwave.recrutatech.interfaces.IUserService;
import com.digitalwave.recrutatech.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepo;

  private BCryptPasswordEncoder passwordEncoder;

  @Transactional
  public Usuario createUser(Usuario usuario) {
    validateUser(usuario);

    // Criptografa a senha usando BCrypt
    passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode(usuario.getPassword());
    usuario.setPassword(hashedPassword);

    usuario.setUserStatus(true); // Defina o status como true por padrão
    usuario.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    usuario.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    return userRepo.save(usuario);
  }

  public List<Usuario> getAllUsers() {
    return userRepo.findAll();
  }

  public Usuario getById(Long id) {
    return userRepo.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));
  }

  @Transactional
  public Usuario updateUser(Long id, Usuario updatedUser) {
    Usuario existingUser = userRepo.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));

    // Atualize os campos do usuário existente conforme necessário
    if (!ObjectUtils.isEmpty(updatedUser.getUsername())) {
      existingUser.setUsername(updatedUser.getUsername());
    }
    if (!ObjectUtils.isEmpty(updatedUser.getEmail())) {
      existingUser.setEmail(updatedUser.getEmail());
    }
    if (!ObjectUtils.isEmpty(updatedUser.getUserStatus())) {
      existingUser.setUserStatus(updatedUser.getUserStatus());
    }

    existingUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    return userRepo.save(existingUser);
  }

  @Transactional
  public Usuario deleteUser(Long id) {
    Usuario user = userRepo.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));

    userRepo.deleteById(id);
    return user;
  }

  private void validateUser(Usuario usuario) {
    if (usuario == null ||
        isNullOrBlank(usuario.getUsername()) ||
        isNullOrBlank(usuario.getEmail()) ||
        usuario.getAutorizacoes() == null ||
        isNullOrBlank(usuario.getPassword())) {
      throw new IllegalArgumentException("Dados inválidos!");
    }
  }

  private boolean isNullOrBlank(String value) {
    return value == null || value.trim().isEmpty();
  }

}
