package com.upao.repository;

import com.upao.entity.Programacion_Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProgramacionCitaRepository extends JpaRepository<Programacion_Cita, Long> {

    @Query("SELECT DISTINCT f.fecha FROM Programacion_Cita f JOIN f.horasCitas h WHERE h.disponible = true")
    List<String> findFechasDisponibles();  // Cambio LocalDate por String

    Optional<Programacion_Cita> findByFecha(String fecha); // Cambio LocalDate por String
}

