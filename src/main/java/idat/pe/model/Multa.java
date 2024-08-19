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
@Table(name = "multas")
public class Multa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_multa")
    private Integer idMulta;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_defecto")
    private Defecto_Libro defecto;
    
    @Column(name = "monto")
    private Double monto;
    
    @Column(name = "fecha_multa")
    private LocalDate fechaMulta;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private String estado;

	public Multa() {
	}

	public Multa(Integer idMulta, Usuario usuario, Defecto_Libro defecto, Double monto, LocalDate fechaMulta,
			String descripcion, String estado) {
		this.idMulta = idMulta;
		this.usuario = usuario;
		this.defecto = defecto;
		this.monto = monto;
		this.fechaMulta = fechaMulta;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(Integer idMulta) {
		this.idMulta = idMulta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Defecto_Libro getDefecto() {
		return defecto;
	}

	public void setDefecto(Defecto_Libro defecto) {
		this.defecto = defecto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDate getFechaMulta() {
		return fechaMulta;
	}

	public void setFechaMulta(LocalDate fechaMulta) {
		this.fechaMulta = fechaMulta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    

}
