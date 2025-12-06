
package com.economi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.economi.modelo.ObjetivoAhorro;

@Repository
public interface ObjetivoAhorroRepository extends CrudRepository<ObjetivoAhorro, Integer> {
    // Buscar objetivos por usuario
    Iterable<ObjetivoAhorro> findByUserId(Integer userId);

    // Buscar objetivos por estado (pendiente/completado)
    Iterable<ObjetivoAhorro> findByEstado(String estado);
}
