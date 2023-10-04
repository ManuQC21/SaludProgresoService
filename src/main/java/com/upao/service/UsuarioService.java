package com.upao.service;

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


    // Método para editar información del usuario
    public GenericResponse<Usuario> editarUsuario(Usuario u, String nuevoNombre, String nuevoGenero, String nuevaDireccion, String nuevoDistrito, String nuevoTelefono, String nuevasAlergias, String nuevaInformacionAdicional) {
        Optional<Usuario> optU = this.repository.findById(u.getId());

        if (optU.isPresent()) {
            Usuario usuarioExistente = optU.get();

            // Verifica si el usuario tiene un paciente relacionado
            if (usuarioExistente.getPaciente() != null) {
                Paciente paciente = usuarioExistente.getPaciente();

                // Actualiza los campos del paciente
                paciente.setNombre(nuevoNombre);
                paciente.setGenero(nuevoGenero);
                paciente.setDireccion(nuevaDireccion);
                paciente.setDistrito(nuevoDistrito);
                paciente.setTelefono(nuevoTelefono);
                paciente.setAlergias(nuevasAlergias);
                paciente.setInformacionadicional(nuevaInformacionAdicional);

                // Guarda el paciente actualizado en la base de datos
                this.pacienteRepository.save(paciente);
            }

            // Guarda el usuario actualizado en la base de datos
            Usuario usuarioActualizado = this.repository.save(usuarioExistente);

            return new GenericResponse<>(TIPO_DATA, RPTA_OK, "Usuario actualizado correctamente", usuarioActualizado);
        } else {
            // El usuario no existe
            return new GenericResponse<>(TIPO_DATA, RPTA_WARNING, "El usuario no existe", null);
        }
    }
}
