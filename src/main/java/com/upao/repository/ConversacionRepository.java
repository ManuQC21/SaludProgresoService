package com.upao.repository;

import com.upao.entity.conversacion.Conversacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ConversacionRepository extends JpaRepository<Conversacion, Integer> {
    Optional<Conversacion> findByPacienteIdAndMedicoId(int pacienteId, int medicoId);
    List<Conversacion> findByPacienteId(int pacienteId);
    List<Conversacion> findByMedicoId(int medicoId);

}
