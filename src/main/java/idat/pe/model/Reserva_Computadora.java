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
@Table(name = "reservascomputadoras")
public class Reserva_Computadora {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva_computadora")
    private Integer idReservaComputadora;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_computadora")
    private Computadora computadora;
    
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    
    @Column(name = "hora_fin")
    private LocalTime horaFin;

	public Reserva_Computadora() {
	}

	public Reserva_Computadora(Integer idReservaComputadora, Usuario usuario, Computadora computadora,
			LocalDate fechaReserva, LocalTime horaInicio, LocalTime horaFin) {
		this.idReservaComputadora = idReservaComputadora;
		this.usuario = usuario;
		this.computadora = computadora;
		this.fechaReserva = fechaReserva;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Integer getIdReservaComputadora() {
		return idReservaComputadora;
	}

	public void setIdReservaComputadora(Integer idReservaComputadora) {
		this.idReservaComputadora = idReservaComputadora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Computadora getComputadora() {
		return computadora;
	}

	public void setComputadora(Computadora computadora) {
		this.computadora = computadora;
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
