package idat.pe.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    
    @Column(name = "estado")
    private String estado;

	public Usuario() {
	}
	
	

	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Usuario(Integer idUsuario, String clave, String nombres, String apellidoPaterno, String apellidoMaterno,
			String email, String celular, String direccion, LocalDate fechaRegistro, String estado) {
		this.idUsuario = idUsuario;
		this.clave = clave;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.celular = celular;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    

}
