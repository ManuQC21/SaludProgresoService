package com.upao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upao.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    // Puedes agregar métodos adicionales de consulta o manipulación de Paciente si es necesario
}