package idat.pe.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasespacioscomunes")
public class Reserva_EspaciosComunes {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_espacio")
    private Integer idReservaEspacio;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @Column(name = "espacio")
    private String espacio;
    
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;
    
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    
    @Column(name = "hora_fin")
    private LocalTime horaFin;

	public Reserva_EspaciosComunes() {
	}

	public Reserva_EspaciosComunes(Integer idReservaEspacio, Usuario usuario, String espacio, LocalDate fechaReserva,
			LocalTime horaInicio, LocalTime horaFin) {
		this.idReservaEspacio = idReservaEspacio;
		this.usuario = usuario;
		this.espacio = espacio;
		this.fechaReserva = fechaReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Integer getIdReservaEspacio() {
		return idReservaEspacio;
	}

	public void setIdReservaEspacio(Integer idReservaEspacio) {
		this.idReservaEspacio = idReservaEspacio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
    
	
}
