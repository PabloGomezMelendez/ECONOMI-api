
package com.economi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.economi.modelo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    // Puedes añadir métodos personalizados si lo necesitas
    Usuario findByEmail(String email);
}
