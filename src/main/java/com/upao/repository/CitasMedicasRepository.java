package com.upao.repository;

import com.upao.entity.CitasMedicas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CitasMedicasRepository extends CrudRepository<CitasMedicas, Integer> {
    @Query("SELECT da FROM CitasMedicas da")
    Iterable<CitasMedicas> list();
}
