package com.biblioteca.demo.Repository;

import com.biblioteca.demo.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface

EditoraRepository extends JpaRepository<Editora, Long>{

    List<Editora> findAll();

    Editora save(Editora editora);
        List<Editora> findByNome(String nome);

    Editora created(Editora editora);
}


