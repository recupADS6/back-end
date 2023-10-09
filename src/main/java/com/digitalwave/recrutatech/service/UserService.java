package com.digitalwave.recrutatech.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.digitalwave.recrutatech.Interfaces.IUserService;
import com.digitalwave.recrutatech.entity.User;
import com.digitalwave.recrutatech.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepo;

  @Transactional
  public User createUser(User user) {
    if (user == null ||
        user.getUserName() == null ||
        user.getUserName().isBlank() ||
        user.getUserEmail() == null ||
        user.getUserEmail().isBlank() ||
        user.getUserPassword() == null ||
        user.getUserPassword().isBlank()) {
      throw new IllegalArgumentException("Dados inválidos!");
    }

    try {
      user.setUserStatus(true); // Defina o status como true por padrão
      user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
      user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
      user = userRepo.save(user);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao inserir usuário!");
    }
    return user;
  }

  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  public User getById(Long id) {
    Optional<User> userOp = userRepo.findById(id);
    if (userOp.isEmpty()) {
      throw new IllegalArgumentException("Usuário não encontrado!");
    }
    return userOp.get();
  }
}
