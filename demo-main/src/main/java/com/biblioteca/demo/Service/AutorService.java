package com.biblioteca.demo.Service;

import com.biblioteca.demo.Repository.AutorRepository;
import com.biblioteca.demo.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {


    @Autowired
    private static AutorRepository repository;
    public static Autor create(Autor autor) {
        return autor.save(autor);
    }

    public Optional<Autor> findById(Long id) {
        return repository.findById(id);
    }
    public static void delete(Long id) {
        repository.deleteById(id);
    }
    public List<Autor> listartodos() {
        return repository.findAll();

    }
}
