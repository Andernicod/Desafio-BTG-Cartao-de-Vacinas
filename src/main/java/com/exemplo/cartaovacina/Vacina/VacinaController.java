package com.exemplo.cartaovacina.Vacina;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.exemplo.cartaovacina.Paciente.Paciente;
import com.exemplo.cartaovacina.Paciente.PacienteRepo;

// Esse é o controller de vacinas, responsável pelas rotas de vacinas
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    private VacinaRepo vacinaRepo;

    @Autowired
    private PacienteRepo pacienteRepo;

    // Lista todas as vacinas
    @GetMapping
    public List<Vacina> getVacinas(@RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return vacinaRepo.findByPacienteNomeContainingIgnoreCaseOrPacienteCpfContainingIgnoreCase(search, search);
        } else {
            return vacinaRepo.findAll();
        }
    }

    // Buscar uma vacina pelo seu ID
    @GetMapping("/{id}")
    public Vacina getVacina(@PathVariable Long id) {
        return vacinaRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A vacina não foi encontrada"));
    }

    // Criar uma nova vacina no banco, com dose, data e o paciente vinculado
    @PostMapping
    public Vacina createVacina(@RequestBody Vacina vacina) {
        if (vacina.getPaciente() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O paciente deve ser informado");
        }
        if (vacina.getPaciente().getId() != null) {
            // Busca paciente pelo id
            var paciente = pacienteRepo.findById(vacina.getPaciente().getId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " O paciente não encontrado"));
            vacina.setPaciente(paciente);
        } else {
            // Caso contrário cria um novo paciente com nome e cpf
            var paciente = new Paciente();
            paciente.setNome(vacina.getPaciente().getNome());
            paciente.setCpf(vacina.getPaciente().getCpf());
            paciente = pacienteRepo.save(paciente);
            vacina.setPaciente(paciente);
        }
        return vacinaRepo.save(vacina); // Salva a vacina e os dados no banco que será usado na carteira de vacinação
    }

    // Atualiza a vacina caso precisa ser editada
    @PutMapping("/{id}")
    public Vacina updateVacina(@PathVariable Long id, @RequestBody Vacina vacinaRequest) {
        Vacina vacina = vacinaRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A vacina não foi encontrada"));
        vacina.setNome(vacinaRequest.getNome());
        vacina.setDataAplicacao(vacinaRequest.getDataAplicacao());
        vacina.setDoseAplicada(vacinaRequest.getDoseAplicada());
        if (vacinaRequest.getPaciente() != null && vacinaRequest.getPaciente().getId() != null) {
            Long pacienteId = vacinaRequest.getPaciente().getId();
            var paciente = pacienteRepo.findById(pacienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O paciente não foi encontrado"));
            vacina.setPaciente(paciente);
        } else {
            vacina.setPaciente(null);
        }
        return vacinaRepo.save(vacina);
    }

    // Deleta a vacina aplicada do banco
    @DeleteMapping("/{id}")
    public void deleteVacina(@PathVariable Long id) {
        Vacina vacina = vacinaRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A vacina não foi encontrada"));
        vacinaRepo.delete(vacina);
    }
}