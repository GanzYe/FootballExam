package com.exam.footballleague.entities;

import lombok.Data;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Data
@Entity
@NoArgsConstructor
public class Role extends BaseEntity implements GrantedAuthority {

  private String role;

  private String description;

  public Role(Long id, String role_user, String user_role) {
    this.setId(id);
    this.role = role_user;
    this.description = user_role;
  }

  @Override public String getAuthority() {
    return getRole();
  }
}