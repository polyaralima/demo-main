package com.biblioteca.demo.controller;

import com.biblioteca.demo.Repository.EditoraRepository;
import com.biblioteca.demo.Service.EditoraService;
import com.biblioteca.demo.entity.Editora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {
    @Autowired
    private EditoraRepository editoraRepository;

    // Endpoint para listar todas as editoras
    @GetMapping
    public List<Editora> listarEditoras() {
        return editoraRepository.findAll();
    }
    // Endpoint para adicionar uma nova editora
    @PostMapping
    public ResponseEntity<Editora> adicionarEditora(@RequestBody Editora editora) {
        Editora novaEditora = editoraRepository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEditora);
    }
    // Endpoint para remover uma editora
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        EditoraService.delete(id);
    }

}
