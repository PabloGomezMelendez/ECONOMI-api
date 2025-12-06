
package com.economi.servicio;

import com.economi.modelo.Simulacion;
import com.economi.repositorio.SimulacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SimulacionService {

    private final SimulacionRepository simulacionRepository;

    public SimulacionService(SimulacionRepository simulacionRepository) {
        this.simulacionRepository = simulacionRepository;
    }

    // Crear simulación
    public Simulacion crearSimulacion(Simulacion simulacion) {
        simulacion.setFecha(LocalDateTime.now());
        return simulacionRepository.save(simulacion);
    }

    // Obtener todas las simulaciones
    public Iterable<Simulacion> obtenerTodas() {
        return simulacionRepository.findAll();
    }

    // Obtener simulación por ID
    public Optional<Simulacion> obtenerPorId(Integer id) {
        return simulacionRepository.findById(id);
    }

    // Actualizar simulación
    public Optional<Simulacion> actualizarSimulacion(Integer id, Simulacion datosActualizados) {
        return simulacionRepository.findById(id).map(simulacionExistente -> {
            simulacionExistente.setUserId(datosActualizados.getUserId());
            simulacionExistente.setTipo(datosActualizados.getTipo());
            simulacionExistente.setParametros(datosActualizados.getParametros());
            simulacionExistente.setResultado(datosActualizados.getResultado());
            return simulacionRepository.save(simulacionExistente);
        });
    }

    // Eliminar simulación
    public boolean eliminarSimulacion(Integer id) {
        if (simulacionRepository.existsById(id)) {
            simulacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar por usuario
    public Iterable<Simulacion> buscarPorUsuario(Integer userId) {
        return simulacionRepository.findByUserId(userId);
    }

    // Buscar por tipo
    public Iterable<Simulacion> buscarPorTipo(String tipo) {
        return simulacionRepository.findByTipo(tipo);
    }
}
