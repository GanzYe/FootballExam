package com.exam.footballleague.repositories;
import com.exam.footballleague.entities.DbUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DbUser, Long> {
  DbUser findUserByEmail(String email);
}

