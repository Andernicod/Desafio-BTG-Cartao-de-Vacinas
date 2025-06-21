package com.exemplo.cartaovacina.Paciente;

import jakarta.persistence.*;

// Essa é a entidade do paciente
@Entity
public class Paciente {
    //Nesse caso aqui optei por usar o id do paciente para linkar com a vacina.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Paciente tem um id(idenficador para user usado futuramente), nome e cpf.
    private Long id;
    private String nome;
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}