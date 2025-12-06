
package com.economi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.economi.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    // Método adicional para buscar por tipo
    Iterable<Categoria> findByTipo(String tipo);
}
