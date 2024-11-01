package com.bnds.prontuario.aplicacao;

import com.bnds.prontuario.dominio.modelo.Paciente;
import com.bnds.prontuario.dominio.repositorio.PacienteRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.listarTodos();
    }

    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.buscarPorId(id);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deletar(id);
    }
}
