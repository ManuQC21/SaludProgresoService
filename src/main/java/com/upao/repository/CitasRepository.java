package com.upao.repository;

import com.upao.entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {

    //Buscar todas las citas de un paciente por su ID
    List<Citas> findByPacienteId(Integer pacienteId);

    @Query("SELECT c FROM Citas c WHERE c.fechaCita.fecha = :fecha AND c.medico.especialidad = :especialidad")
    List<Citas> findByFechaAndEspecialidad(@Param("fecha") String fecha, @Param("especialidad") String especialidad);


}

