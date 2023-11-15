package com.upao.repository;

import com.upao.entity.DisponibilidadMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadMedicoRepository extends JpaRepository<DisponibilidadMedico, Long> {
    // Métodos necesarios
}
