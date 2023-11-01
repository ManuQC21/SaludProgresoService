package com.upao.repository;

import com.upao.entity.CitasMedicas;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface CitasMedicasRepository extends CrudRepository<CitasMedicas, Integer> {
    @Query("SELECT da FROM CitasMedicas da")
    Iterable<CitasMedicas> list();

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM citas_medicas WHERE fecha_hora_cita = :fechaHoraCita", nativeQuery = true)
    int existCita(@Param("fechaHoraCita") LocalDateTime fechaHoraCita);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM citas_medicas WHERE fecha_hora_cita = :fechaHoraCita AND id <> :id", nativeQuery = true)
    int existCitaUpdate(@Param("fechaHoraCita") LocalDateTime fechaHoraCita, @Param("id") int id);

}
