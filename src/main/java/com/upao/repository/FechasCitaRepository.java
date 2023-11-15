package com.upao.repository;

import com.upao.entity.FechasCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FechasCitaRepository extends JpaRepository<FechasCitas, Long> {

    @Query("SELECT DISTINCT f.fecha FROM FechasCitas f JOIN f.horasCitas h WHERE h.disponible = true")
    List<String> findFechasDisponibles();  // Cambio LocalDate por String

    Optional<FechasCitas> findByFecha(String fecha); // Cambio LocalDate por String
}

