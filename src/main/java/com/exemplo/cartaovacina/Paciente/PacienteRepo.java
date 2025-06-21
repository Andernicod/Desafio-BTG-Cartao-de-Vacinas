package com.exemplo.cartaovacina.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

// Esse é o repositório do paciente
public interface PacienteRepo extends JpaRepository<Paciente, Long> {
}