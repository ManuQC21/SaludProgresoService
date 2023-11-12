package com.upao.repository;

import com.upao.entity.FechasCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FechasCitaRepository extends JpaRepository<FechasCitas, Long> {

    //Buscar fechas disponibles
    @Query("SELECT DISTINCT f.fecha FROM FechasCitas f JOIN f.horasCitas h WHERE h.disponible = true")
    List<LocalDate> findFechasDisponibles();
    // Buscar una fecha específica
    Optional<FechasCitas> findByFecha(LocalDate fecha);

}
