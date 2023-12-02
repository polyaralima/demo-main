package com.biblioteca.demo.Repository;

import com.biblioteca.demo.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAll(String nome);
    Optional<Livro> findById(Long id);
    void deleteById(Long id);

}
