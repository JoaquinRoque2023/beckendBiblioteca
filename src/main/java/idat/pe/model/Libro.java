package idat.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idLibro;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "autor")
    private String autor;
    
    @Column(name = "editorial")
    private String editorial;
    
    @Column(name = "año_publicacion")
    private Integer añoPublicacion;
    
    @Column(name = "isbn")
    private String isbn;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "ubicacion")
    private String ubicacion;
    
    @Column(name = "estado")
    private String estado;

	public Libro() {
	}

	
	public Libro(Integer idLibro) {
		this.idLibro = idLibro;
	}


	public Libro(Integer idLibro, String titulo, String autor, String editorial, Integer añoPublicacion, String isbn,
			String categoria, String ubicacion, String estado) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.añoPublicacion = añoPublicacion;
		this.isbn = isbn;
		this.categoria = categoria;
		this.ubicacion = ubicacion;
		this.estado = estado;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(Integer añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
