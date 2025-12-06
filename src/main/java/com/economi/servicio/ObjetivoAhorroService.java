
package com.economi.servicio;

import com.economi.modelo.ObjetivoAhorro;
import com.economi.repositorio.ObjetivoAhorroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObjetivoAhorroService {

    private final ObjetivoAhorroRepository objetivoAhorroRepository;

    public ObjetivoAhorroService(ObjetivoAhorroRepository objetivoAhorroRepository) {
        this.objetivoAhorroRepository = objetivoAhorroRepository;
    }

    // Crear objetivo
    public ObjetivoAhorro crearObjetivo(ObjetivoAhorro objetivo) {
        return objetivoAhorroRepository.save(objetivo);
    }

    // Obtener todos los objetivos
    public Iterable<ObjetivoAhorro> obtenerTodos() {
        return objetivoAhorroRepository.findAll();
    }

    // Obtener objetivo por ID
    public Optional<ObjetivoAhorro> obtenerPorId(Integer id) {
        return objetivoAhorroRepository.findById(id);
    }

    // Actualizar objetivo
    public Optional<ObjetivoAhorro> actualizarObjetivo(Integer id, ObjetivoAhorro datosActualizados) {
        return objetivoAhorroRepository.findById(id).map(objetivoExistente -> {
            objetivoExistente.setUserId(datosActualizados.getUserId());
            objetivoExistente.setNombre(datosActualizados.getNombre());
            objetivoExistente.setMontoObjetivo(datosActualizados.getMontoObjetivo());
            objetivoExistente.setFechaLimite(datosActualizados.getFechaLimite());
            objetivoExistente.setEstado(datosActualizados.getEstado());
            return objetivoAhorroRepository.save(objetivoExistente);
        });
    }

    // Eliminar objetivo
    public boolean eliminarObjetivo(Integer id) {
        if (objetivoAhorroRepository.existsById(id)) {
            objetivoAhorroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar por usuario
    public Iterable<ObjetivoAhorro> buscarPorUsuario(Integer userId) {
        return objetivoAhorroRepository.findByUserId(userId);
    }

    // Buscar por estado
    public Iterable<ObjetivoAhorro> buscarPorEstado(String estado) {
        return objetivoAhorroRepository.findByEstado(estado);
    }
}
