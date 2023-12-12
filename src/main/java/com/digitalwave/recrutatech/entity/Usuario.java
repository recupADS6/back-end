package com.digitalwave.recrutatech.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long id;

  @Column(name = "user_name")
  private String username;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  // @JsonIgnore
  private String password;

  @Column(name = "user_status")
  private Boolean userStatus;

  @Column(name = "created_at")
  private java.sql.Timestamp createdAt;

  @Column(name = "updated_at")
  private java.sql.Timestamp updatedAt;

  @ManyToMany
    @JoinTable(name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id")},
        inverseJoinColumns = { @JoinColumn(name = "aut_id") }
        )
    private List<Autorizacao> autorizacoes;

  public Usuario() {
    autorizacoes = new ArrayList<Autorizacao>();
  }

  public Usuario(long id, String username, String email, String password, Boolean userStatus,
      Timestamp createdAt, Timestamp updatedAt) {
    this();
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.userStatus = userStatus;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Boolean userStatus) {
    this.userStatus = userStatus;
  }

  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<Autorizacao> getAutorizacoes() {
    return autorizacoes;
  }

  public void setAutorizacoes(List<Autorizacao> autorizacoes) {
    this.autorizacoes = autorizacoes;
  }

}
