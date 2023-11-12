package com.upao.repository;

import com.upao.entity.DocumentoAlmacenado;
import com.upao.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.clave=:password")
    Optional<Usuario> login(String correo, String password);


    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);  // Agregar este método

    @Query("SELECT u FROM Usuario u")
    Iterable<Usuario> list();
}

