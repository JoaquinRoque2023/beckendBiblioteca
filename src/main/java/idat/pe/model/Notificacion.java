package idat.pe.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @Column(name = "tipo_notificacion")
    private String tipoNotificacion;
    
    @Column(name = "mensaje")
    private String mensaje;
    
    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

	public Notificacion() {
	}

	public Notificacion(Integer idNotificacion, Usuario usuario, String tipoNotificacion, String mensaje,
			LocalDate fechaEnvio) {
		this.idNotificacion = idNotificacion;
		this.usuario = usuario;
		this.tipoNotificacion = tipoNotificacion;
		this.mensaje = mensaje;
		this.fechaEnvio = fechaEnvio;
	}

	public Integer getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Integer idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
    
    
}
