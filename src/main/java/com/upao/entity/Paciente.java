package com.upao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    @Size(max = 100, message = "Los nombres no pueden exceder los 100 caracteres.")
    private String nombres;
    @Column(length = 100)
    @Size(max = 100, message = "El apellido paterno no puede exceder los 100 caracteres.")
    private String apellidoPaterno;
    @Column(length = 100)
    @Size(max = 100, message = "El apellido materno no puede exceder los 100 caracteres.")
    private String apellidoMaterno;
    @Column(length = 100)
    private String fechanacimiento;
    @Column(length = 20)
    private String tipoDoc;
    @Column(length = 8)
    private String numDoc;
    @Column(length = 100)
    private String departamento;
    @Column(length = 100)
    private String provincia;
    @Column(length = 100)
    private String distrito;
    @Column(length = 100)
    private String direccion;
    @Column(length = 100)
    private String genero;
    @Column(length = 9)
    private String telefono;
    @Column(length = 100)
    private String alergias;
    @Column(length = 400)
    private String informacionadicional;
    @OneToOne
    private Foto foto;

    public int getId() {
        return id;
    }

    public void setId(int ID_Paciente) {
        this.id = ID_Paciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getInformacionadicional() {
        return informacionadicional;
    }

    public void setInformacionadicional(String informacionadicional) {
        this.informacionadicional = informacionadicional;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

}
