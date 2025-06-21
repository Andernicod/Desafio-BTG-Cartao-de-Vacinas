package com.exemplo.cartaovacina.Vacina;

import jakarta.persistence.*;
import com.exemplo.cartaovacina.Paciente.Paciente;
import java.time.LocalDate;

// Está é a entidade para vacina, que representaria as vacinas e o paciente que recebeu para carregar na carteira de vacinação
@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataAplicacao;

    private String doseAplicada;

    // Vacina está relacionada a um Paciente (seu id), então usamos ManyToOne para indicar que várias vacinas podem ser aplicadas a um único paciente, assim teriamos sua carteira de vacinação
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

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

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getDoseAplicada() {
        return doseAplicada;
    }

    public void setDoseAplicada(String doseAplicada) {
        this.doseAplicada = doseAplicada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}