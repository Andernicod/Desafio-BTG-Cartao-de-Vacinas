package com.exemplo.cartaovacina.Vacina;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// Esse é o repositório de vacinas
public interface VacinaRepo extends JpaRepository<Vacina, Long> {
    List<Vacina> findByPacienteNomeContainingIgnoreCaseOrPacienteCpfContainingIgnoreCase(String nome, String cpf);
    List<Vacina> findByNomeContainingIgnoreCase(String nome);
}