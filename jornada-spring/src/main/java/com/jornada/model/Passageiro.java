package com.jornada.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    public Passageiro() {
    }

    public Passageiro(String nome, int idade, String usuario, String senha, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, usuario, senha, cpf, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passageiro passageiro = (Passageiro) obj;
        return idade == passageiro.idade &&
                Objects.equals(id, passageiro.id) &&
                Objects.equals(nome, passageiro.nome) &&
                Objects.equals(usuario, passageiro.usuario) &&
                Objects.equals(senha, passageiro.senha) &&
                Objects.equals(cpf, passageiro.cpf) &&
                Objects.equals(email, passageiro.email);
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}