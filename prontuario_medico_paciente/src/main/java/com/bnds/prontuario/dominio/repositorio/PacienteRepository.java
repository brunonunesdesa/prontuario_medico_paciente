package com.bnds.prontuario.dominio.repositorio;

import com.bnds.prontuario.dominio.modelo.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteRepository {
    Paciente salvar(Paciente paciente);
    List<Paciente> listarTodos();
    Optional<Paciente> buscarPorId(Long id);
    void deletar(Long id);
}
