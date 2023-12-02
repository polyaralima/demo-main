package com.biblioteca.demo.Service;

import com.biblioteca.demo.Repository.EditoraRepository;
import com.biblioteca.demo.entity.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private static EditoraRepository repository;
    public Editora salvar (Editora editora){
        return repository.save(editora);
    }
    public Editora criar (Editora editora){
        return repository.created(editora);
    }
    public static void delete(Long id) {
        repository.deleteById(id);
    }
    public Optional<Editora> findById(Long id) {
        return repository.findById(id);
    }
}
