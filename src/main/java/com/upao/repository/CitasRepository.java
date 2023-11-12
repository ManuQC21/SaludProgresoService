package com.upao.repository;

import com.upao.entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {

    //Buscar todas las citas de un paciente por su ID
    List<Citas> findByPacienteId(Integer pacienteId);

}

