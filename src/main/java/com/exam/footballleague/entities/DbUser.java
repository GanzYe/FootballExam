package com.exam.footballleague.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DbUser extends BaseEntity {

  @Column(name = "email", unique = true)
  private String email;

  private String password;

  private String fullName;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Role> roles;

}
