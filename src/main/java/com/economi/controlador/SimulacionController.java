
package com.economi.controlador;

import com.economi.modelo.Simulacion;
import com.economi.servicio.SimulacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/simulaciones")
public class SimulacionController {

    private final SimulacionService simulacionService;

    public SimulacionController(SimulacionService simulacionService) {
        this.simulacionService = simulacionService;
    }

    // Crear simulación
    @PostMapping
    public ResponseEntity<Simulacion> crearSimulacion(@RequestBody Simulacion simulacion) {
        Simulacion nuevaSimulacion = simulacionService.crearSimulacion(simulacion);
        return ResponseEntity.ok(nuevaSimulacion);
    }

    // Obtener todas las simulaciones
    @GetMapping
    public ResponseEntity<Iterable<Simulacion>> obtenerTodas() {
        return ResponseEntity.ok(simulacionService.obtenerTodas());
    }

    // Obtener simulación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Simulacion> obtenerPorId(@PathVariable Integer id) {
        Optional<Simulacion> simulacion = simulacionService.obtenerPorId(id);
        return simulacion.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar simulación
    @PutMapping("/{id}")
    public ResponseEntity<Simulacion> actualizarSimulacion(@PathVariable Integer id, @RequestBody Simulacion simulacion) {
        Optional<Simulacion> actualizada = simulacionService.actualizarSimulacion(id, simulacion);
        return actualizada.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar simulación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSimulacion(@PathVariable Integer id) {
        boolean eliminado = simulacionService.eliminarSimulacion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Buscar simulaciones por usuario
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<Iterable<Simulacion>> buscarPorUsuario(@PathVariable Integer userId) {
        return ResponseEntity.ok(simulacionService.buscarPorUsuario(userId));
    }

    // Buscar simulaciones por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Iterable<Simulacion>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(simulacionService.buscarPorTipo(tipo));
    }
}
