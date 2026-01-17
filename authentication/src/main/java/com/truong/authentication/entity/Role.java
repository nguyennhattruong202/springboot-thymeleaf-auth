package com.truong.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @ManyToMany(mappedBy = "roles")
  private List<User> users = new ArrayList<>();
}
