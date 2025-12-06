
package com.economi.servicio;

import com.economi.modelo.Transaccion;
import com.economi.repositorio.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    // Crear transacción
    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    // Obtener todas las transacciones
    public Iterable<Transaccion> obtenerTodas() {
        return transaccionRepository.findAll();
    }

    // Obtener transacción por ID
    public Optional<Transaccion> obtenerPorId(Integer id) {
        return transaccionRepository.findById(id);
    }

    // Actualizar transacción
    public Optional<Transaccion> actualizarTransaccion(Integer id, Transaccion datosActualizados) {
        return transaccionRepository.findById(id).map(transaccionExistente -> {
            transaccionExistente.setIdUsuario(datosActualizados.getIdUsuario());
            transaccionExistente.setIdCategoria(datosActualizados.getIdCategoria());
            transaccionExistente.setCantidad(datosActualizados.getCantidad());
            transaccionExistente.setFecha(datosActualizados.getFecha());
            transaccionExistente.setTipo(datosActualizados.getTipo());
            transaccionExistente.setDescripcion(datosActualizados.getDescripcion());
            return transaccionRepository.save(transaccionExistente);
        });
    }

    // Eliminar transacción
    public boolean eliminarTransaccion(Integer id) {
        if (transaccionRepository.existsById(id)) {
            transaccionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar por usuario
    public Iterable<Transaccion> buscarPorUsuario(Integer idUsuario) {
        return transaccionRepository.findByIdUsuario(idUsuario);
    }

    // Buscar por categoría
    public Iterable<Transaccion> buscarPorCategoria(Integer idCategoria) {
        return transaccionRepository.findByIdCategoria(idCategoria);
    }

    // Buscar por tipo
    public Iterable<Transaccion> buscarPorTipo(String tipo) {
        return transaccionRepository.findByTipo(tipo);
    }
}
