
package com.economi.controlador;

import com.economi.modelo.Transaccion;
import com.economi.servicio.TransaccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    // Crear transacción
    @PostMapping
    public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {
        Transaccion nuevaTransaccion = transaccionService.crearTransaccion(transaccion);
        return ResponseEntity.ok(nuevaTransaccion);
    }

    // Obtener todas las transacciones
    @GetMapping
    public ResponseEntity<Iterable<Transaccion>> obtenerTodas() {
        return ResponseEntity.ok(transaccionService.obtenerTodas());
    }

    // Obtener transacción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerPorId(@PathVariable Integer id) {
        Optional<Transaccion> transaccion = transaccionService.obtenerPorId(id);
        return transaccion.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar transacción
    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> actualizarTransaccion(@PathVariable Integer id, @RequestBody Transaccion transaccion) {
        Optional<Transaccion> actualizada = transaccionService.actualizarTransaccion(id, transaccion);
        return actualizada.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar transacción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Integer id) {
        boolean eliminado = transaccionService.eliminarTransaccion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Buscar por usuario
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Iterable<Transaccion>> buscarPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(transaccionService.buscarPorUsuario(idUsuario));
    }

    // Buscar por categoría
    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<Iterable<Transaccion>> buscarPorCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(transaccionService.buscarPorCategoria(idCategoria));
    }

    // Buscar por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Iterable<Transaccion>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(transaccionService.buscarPorTipo(tipo));
    }
}
