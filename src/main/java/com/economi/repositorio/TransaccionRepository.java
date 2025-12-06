
package com.economi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.economi.modelo.Transaccion;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Integer> {
    // Buscar transacciones por usuario
    Iterable<Transaccion> findByIdUsuario(Integer idUsuario);

    // Buscar transacciones por categoría
    Iterable<Transaccion> findByIdCategoria(Integer idCategoria);

    // Buscar transacciones por tipo (gasto/ingreso)
    Iterable<Transaccion> findByTipo(String tipo);
}
