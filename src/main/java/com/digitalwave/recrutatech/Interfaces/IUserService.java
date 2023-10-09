package com.digitalwave.recrutatech.Interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.User;

public interface IUserService {
  User getById(Long id);
  User createUser(User user);
  List<User> getAllUsers();
}
