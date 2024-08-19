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
@Table(name = "defectoslibros")
public class Defecto_Libro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_defecto")
    private Integer idDefecto;
    
    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
    
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    
    @Column(name = "descripcion")
    private String descripcion;

	public Defecto_Libro() {
	}

	public Defecto_Libro(Integer idDefecto, Libro libro, LocalDate fechaRegistro, String descripcion) {
		this.idDefecto = idDefecto;
		this.libro = libro;
		this.fechaRegistro = fechaRegistro;
		this.descripcion = descripcion;
	}

	public Integer getIdDefecto() {
		return idDefecto;
	}

	public void setIdDefecto(Integer idDefecto) {
		this.idDefecto = idDefecto;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
