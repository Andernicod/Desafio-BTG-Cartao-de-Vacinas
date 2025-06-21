package com.exemplo.cartaovacina.Paciente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

// Aqui temos o controller do paciente
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
// Este é o endpoint para acessar a api de pacientes
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepo pacienteRepo;

    // Metodo get do paciente 
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepo.findAll();
    }

    // Aqui ele pode buscar o paciente por id
    @GetMapping("/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O paciente não foi encontrado"));
    }

    // Metodo post do paciente
    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteRepo.save(paciente);
    }

    // Nesse metodo ele faz o update do paciente
    @PutMapping("/{id}")
    public Paciente updatePaciente(@RequestBody Paciente pacienteRequest, @PathVariable Long id) {
        Paciente paciente = pacienteRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

        paciente.setNome(pacienteRequest.getNome());
        paciente.setCpf(pacienteRequest.getCpf());

        return pacienteRepo.save(paciente);
    }

    // Metodo delete do paciente
    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
        pacienteRepo.delete(paciente);
    }
}