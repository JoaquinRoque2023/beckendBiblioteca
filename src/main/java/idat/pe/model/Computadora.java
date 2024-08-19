package idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "computadoras")
public class Computadora {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_computadora")
    private Integer idComputadora;
    
    @Column(name = "numero_computadora")
    private Integer numeroComputadora;
    
    @Column(name = "ubicacion")
    private String ubicacion;

	public Computadora() {
	}

	public Computadora(Integer idComputadora, Integer numeroComputadora, String ubicacion) {
		this.idComputadora = idComputadora;
		this.numeroComputadora = numeroComputadora;
		this.ubicacion = ubicacion;
	}

	public Integer getIdComputadora() {
		return idComputadora;
	}

	public void setIdComputadora(Integer idComputadora) {
		this.idComputadora = idComputadora;
	}

	public Integer getNumeroComputadora() {
		return numeroComputadora;
	}

	public void setNumeroComputadora(Integer numeroComputadora) {
		this.numeroComputadora = numeroComputadora;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
