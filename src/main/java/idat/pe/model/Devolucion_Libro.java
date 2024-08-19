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
@Table(name = "devolucioneslibros")
public class Devolucion_Libro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private Integer idDevolucion;
    
    @ManyToOne
    @JoinColumn(name = "id_prestamo")
    private Prestamo_Libro prestamo;
    
    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;
    
    @Column(name = "estado_libro")
    private String estadoLibro;

	public Devolucion_Libro() {
	}

	public Devolucion_Libro(Integer idDevolucion, Prestamo_Libro prestamo, LocalDate fechaDevolucion,
			String estadoLibro) {
		this.idDevolucion = idDevolucion;
		this.prestamo = prestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.estadoLibro = estadoLibro;
	}

	public Integer getIdDevolucion() {
		return idDevolucion;
	}

	public void setIdDevolucion(Integer idDevolucion) {
		this.idDevolucion = idDevolucion;
	}

	public Prestamo_Libro getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo_Libro prestamo) {
		this.prestamo = prestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(String estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
    
}
