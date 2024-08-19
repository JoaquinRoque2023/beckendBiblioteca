package idat.pe;

import java.time.LocalDateTime;

public class Respuesta {
	
	private String codigoRetorno;
	
	private String mensaje;
	
	private LocalDateTime fecha;

	public Respuesta(String codigoRetorno, String mensaje) {
		this.codigoRetorno = codigoRetorno;
		this.mensaje = mensaje;
		this.fecha = LocalDateTime.now();
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
