package com.truong.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic(optional = false)
  @Column(name = "name", nullable = false)
  private String name;
  @Basic(optional = false)
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Basic(optional = false)
  @Column(name = "password", nullable = false)
  private String password;
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(
          name = "user_role",
          joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private List<Role> roles = new ArrayList<>();
}
