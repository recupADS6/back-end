package com.digitalwave.recrutatech.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digitalwave.recrutatech.entity.Autorizacao;
import com.digitalwave.recrutatech.entity.Usuario;
import com.digitalwave.recrutatech.repository.UserRepository;

@Service
public class SecurityService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOp = userRepository.findByEmail(email);
        if(usuarioOp.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        Usuario usuario = usuarioOp.get();
        return User.builder().username(email).password(usuario.getPassword())
            .authorities(usuario.getAutorizacoes().stream()
            .map(Autorizacao::getNome).collect(Collectors.toList())
            .toArray(new String[usuario.getAutorizacoes().size()]))
        .build();
    }
}
