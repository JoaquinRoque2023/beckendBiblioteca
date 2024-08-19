package idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.pe.Respuesta;
import idat.pe.model.Libro;
import idat.pe.service.LibroService;

@RestController
@RequestMapping("/biblioteca")
public class NotificacionController {

    @PostMapping("/alertas")
    public ResponseEntity<Void> enviarAlerta(@RequestBody AlertaRequest alertaRequest) {
       
        return ResponseEntity.ok().build();
    }
}

class AlertaRequest {
    private String mensaje;

    // Constructor, getters y setters
    public AlertaRequest() {}
    
    public AlertaRequest(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
