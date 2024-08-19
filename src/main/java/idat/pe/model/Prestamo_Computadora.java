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
@Table(name = "prestamoscomputadoras")
public class Prestamo_Computadora {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo_computadora")
    private Integer idPrestamoComputadora;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_computadora")
    private Computadora computadora;
    
    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;
    
    @Column(name = "hora_prestamo")
    private LocalTime horaPrestamo;
    
    @Column(name = "hora_devolucion")
    private LocalTime horaDevolucion;

	public Prestamo_Computadora() {
	}

	public Prestamo_Computadora(Integer idPrestamoComputadora, Usuario usuario, Computadora computadora,
			LocalDate fechaPrestamo, LocalTime horaPrestamo, LocalTime horaDevolucion) {
		this.idPrestamoComputadora = idPrestamoComputadora;
		this.usuario = usuario;
		this.computadora = computadora;
		this.fechaPrestamo = fechaPrestamo;
		this.horaPrestamo = horaPrestamo;
		this.horaDevolucion = horaDevolucion;
	}

	public Integer getIdPrestamoComputadora() {
		return idPrestamoComputadora;
	}

	public void setIdPrestamoComputadora(Integer idPrestamoComputadora) {
		this.idPrestamoComputadora = idPrestamoComputadora;
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

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalTime getHoraPrestamo() {
		return horaPrestamo;
	}

	public void setHoraPrestamo(LocalTime horaPrestamo) {
		this.horaPrestamo = horaPrestamo;
	}

	public LocalTime getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(LocalTime horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}
    

}
