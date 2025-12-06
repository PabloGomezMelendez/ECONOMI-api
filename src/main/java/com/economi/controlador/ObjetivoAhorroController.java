
package com.economi.controlador;

import com.economi.modelo.ObjetivoAhorro;
import com.economi.servicio.ObjetivoAhorroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/objetivos")
public class ObjetivoAhorroController {

    private final ObjetivoAhorroService objetivoAhorroService;

    public ObjetivoAhorroController(ObjetivoAhorroService objetivoAhorroService) {
        this.objetivoAhorroService = objetivoAhorroService;
    }

    // Crear objetivo
    @PostMapping
    public ResponseEntity<ObjetivoAhorro> crearObjetivo(@RequestBody ObjetivoAhorro objetivo) {
        ObjetivoAhorro nuevoObjetivo = objetivoAhorroService.crearObjetivo(objetivo);
        return ResponseEntity.ok(nuevoObjetivo);
    }

    // Obtener todos los objetivos
    @GetMapping
    public ResponseEntity<Iterable<ObjetivoAhorro>> obtenerTodos() {
        return ResponseEntity.ok(objetivoAhorroService.obtenerTodos());
    }

    // Obtener objetivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoAhorro> obtenerPorId(@PathVariable Integer id) {
        Optional<ObjetivoAhorro> objetivo = objetivoAhorroService.obtenerPorId(id);
        return objetivo.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar objetivo
    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoAhorro> actualizarObjetivo(@PathVariable Integer id, @RequestBody ObjetivoAhorro objetivo) {
        Optional<ObjetivoAhorro> actualizado = objetivoAhorroService.actualizarObjetivo(id, objetivo);
        return actualizado.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar objetivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObjetivo(@PathVariable Integer id) {
        boolean eliminado = objetivoAhorroService.eliminarObjetivo(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Buscar objetivos por usuario
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<Iterable<ObjetivoAhorro>> buscarPorUsuario(@PathVariable Integer userId) {
        return ResponseEntity.ok(objetivoAhorroService.buscarPorUsuario(userId));
    }

    // Buscar objetivos por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<ObjetivoAhorro>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(objetivoAhorroService.buscarPorEstado(estado));
    }
}
