
package com.economi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.economi.modelo.Simulacion;

@Repository
public interface SimulacionRepository extends CrudRepository<Simulacion, Integer> {
    // Buscar simulaciones por usuario
    Iterable<Simulacion> findByUserId(Integer userId);

    // Buscar simulaciones por tipo (inversión o ahorro)
    Iterable<Simulacion> findByTipo(String tipo);
}
