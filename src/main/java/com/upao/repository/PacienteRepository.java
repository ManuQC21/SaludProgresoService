package com.upao.repository;

import com.upao.entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
    @Query(value = "(SELECT EXISTS(SELECT id FROM paciente WHERE num_doc=:dni))", nativeQuery = true)
    int existByDoc(String dni);
    @Query(value = "SELECT EXISTS(SELECT C.* FROM paciente C WHERE C.num_doc=:dni AND NOT (C.id=:id))", nativeQuery = true)
    int existByDocForUpdate(String dni, int id);
}
