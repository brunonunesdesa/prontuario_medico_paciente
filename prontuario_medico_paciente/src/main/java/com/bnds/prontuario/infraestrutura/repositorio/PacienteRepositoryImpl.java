package com.bnds.prontuario.infraestrutura.repositorio;

import com.bnds.prontuario.dominio.modelo.Paciente;
import com.bnds.prontuario.dominio.repositorio.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Paciente salvar(Paciente paciente) {
        entityManager.persist(paciente);
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        return entityManager.createQuery("from Paciente", Paciente.class).getResultList();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager.find(Paciente.class, id));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Paciente paciente = entityManager.find(Paciente.class, id);
        if (paciente != null) {
            entityManager.remove(paciente);
        }
    }
}
