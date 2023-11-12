package com.upao.service;

import com.upao.entity.DocumentoAlmacenado;
import com.upao.entity.Paciente;
import com.upao.entity.Usuario;
import com.upao.repository.PacienteRepository;
import com.upao.repository.UsuarioRepository;
import com.upao.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.upao.utils.Global.*;
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PacienteRepository pacienteRepository; // Inyecta PacienteRepository

    public UsuarioService(UsuarioRepository repository, PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.pacienteRepository = pacienteRepository; // Inicializa PacienteRepository
    }
    //Método para iniciar sesión
    public GenericResponse<Usuario> login(String correo, String clave){
        Optional<Usuario> optU = this.repository.login(correo, clave);
        if(optU.isPresent()){
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "Haz iniciado sesión correctamente", optU.get());
        }else{
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
        }
    }
    //Método para guardar credenciales del usuario
    public GenericResponse guardarUsuario(Usuario u){
        Optional<Usuario> optU = this.repository.findById(u.getId());
        int idf = optU.isPresent() ? optU.get().getId() : 0;
        if(idf == 0){
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario Registrado Correctamente", this.repository.save(u));
        }else{
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del usuario actualizados", this.repository.save(u));
        }
    }
    public GenericResponse<Iterable<Usuario>> listar() {
        return new GenericResponse<Iterable<Usuario>>(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, repository.list());
    }
}
