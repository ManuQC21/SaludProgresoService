package com.upao.repository;

import com.upao.entity.Horario_Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HorarioCitaRepository extends JpaRepository<Horario_Cita, Long> {

    @Query("SELECT h FROM Horario_Cita h WHERE h.fechaCita.fecha = :fecha AND h.disponible = true")
    List<Horario_Cita> findHorasDisponiblesEnFecha(@Param("fecha") String fecha); // Cambio LocalDate por String
}

