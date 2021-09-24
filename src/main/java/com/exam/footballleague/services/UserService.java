package com.exam.footballleague.services;
import java.util.List;

import com.exam.footballleague.entities.DbUser;


import com.exam.footballleague.entities.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  DbUser getUser(String email);

  DbUser registerUser(DbUser user);

  DbUser updateUser(DbUser user);

  void deleteUser(Long id);

  List<DbUser> getUsers();

  List<DbUser> getUsersPaged(Integer currentPage, Integer length, Role role);
}


