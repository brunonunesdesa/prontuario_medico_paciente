package com.bnds.prontuario.interface_adaptador;

import com.bnds.prontuario.aplicacao.PacienteService;
import com.bnds.prontuario.dominio.modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.salvarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPacientePorId(@PathVariable Long id) {
        return pacienteService.buscarPacientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
    }
}
