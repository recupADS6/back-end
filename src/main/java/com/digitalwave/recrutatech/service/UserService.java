package com.digitalwave.recrutatech.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import com.digitalwave.recrutatech.entity.Autorizacao;
import com.digitalwave.recrutatech.entity.Usuario;
import com.digitalwave.recrutatech.interfaces.IUserService;
import com.digitalwave.recrutatech.repository.AutorizacaoRepository;
import com.digitalwave.recrutatech.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private AutorizacaoRepository autorizacaoRepo;

  @Autowired
    private PasswordEncoder passwordEncoder;

  // private BCryptPasswordEncoder passwordEncoder;

  public Usuario createUser(Usuario usuario) {
    if (usuario == null ||
        usuario.getAutorizacoes() == null ||
        usuario.getUsername() == null ||
        usuario.getUsername().isBlank() ||
        usuario.getPassword() == null ||
        usuario.getPassword().isBlank()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para usuario!");
    }
    List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
    for (Autorizacao aut : usuario.getAutorizacoes()) {
      Autorizacao nova;
      if (aut.getId() == null) {
        nova = novaAutorizacao(aut);
      } else {
        Optional<Autorizacao> autOp = autorizacaoRepo.findById(aut.getId());
        if (autOp.isEmpty()) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,
              "Autorizacao com id " + aut.getId() + " nao encontrada!");
        }
        nova = autOp.get();
      }
      autorizacoes.add(nova);
    }
    usuario.setAutorizacoes(autorizacoes);
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    return userRepo.save(usuario);
  }

  private Autorizacao novaAutorizacao(Autorizacao aut) {
    if (aut.getNome() == null || aut.getNome().isBlank()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos para autorizacao!");
    }
    return autorizacaoRepo.save(aut);
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

}
