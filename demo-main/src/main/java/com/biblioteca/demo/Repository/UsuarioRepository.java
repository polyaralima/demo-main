package com.biblioteca.demo.Repository;

import com.biblioteca.demo.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    void deleteById(Long id);
    Optional<Usuario> findById(Long id);
    Usuario created(Usuario usuario);
}
