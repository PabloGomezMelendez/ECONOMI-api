
package com.economi.servicio;

import com.economi.modelo.Categoria;
import com.economi.repositorio.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Crear categoría
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Obtener todas las categorías
    public Iterable<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    // Obtener por ID
    public Optional<Categoria> obtenerPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Actualizar categoría
    public Optional<Categoria> actualizarCategoria(Integer id, Categoria datosActualizados) {
        return categoriaRepository.findById(id).map(categoriaExistente -> {
            categoriaExistente.setNombre(datosActualizados.getNombre());
            categoriaExistente.setTipo(datosActualizados.getTipo());
            categoriaExistente.setDescripcion(datosActualizados.getDescripcion());
            return categoriaRepository.save(categoriaExistente);
        });
    }

    // Eliminar categoría
    public boolean eliminarCategoria(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar por tipo (gasto/ingreso)
    public Iterable<Categoria> buscarPorTipo(String tipo) {
        return categoriaRepository.findByTipo(tipo);
    }
}
