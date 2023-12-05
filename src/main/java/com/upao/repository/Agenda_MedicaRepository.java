package com.upao.repository;

import com.upao.entity.Agenda_Medica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Agenda_MedicaRepository extends JpaRepository<Agenda_Medica, Long> {
}
