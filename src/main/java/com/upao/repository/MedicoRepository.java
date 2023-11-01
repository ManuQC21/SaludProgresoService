    package com.upao.repository;

    import com.upao.entity.Medico;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.data.repository.query.Param;

    public interface MedicoRepository extends CrudRepository<Medico, Integer> {
        @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM medico WHERE email = :email AND id <> :id", nativeQuery = true)
        int existeMedico(@Param("email") String email, @Param("id") int id);
    }