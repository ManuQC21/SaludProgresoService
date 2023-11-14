package com.upao.repository;

import com.upao.entity.HorasCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HorasCitasRepository extends JpaRepository<HorasCitas, Long> {

    @Query("SELECT h FROM HorasCitas h WHERE h.fechaCita.fecha = :fecha AND h.disponible = true")
    List<HorasCitas> findHorasDisponiblesEnFecha(@Param("fecha") String fecha); // Cambio LocalDate por String
}

