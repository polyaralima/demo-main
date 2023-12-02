package com.biblioteca.demo.entity;



import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)

@Builder(toBuilder = true)
public class Autor implements Serializable {

    private final Long id;

    private String nome;

    private String email;


    public Autor save(Autor autor) {
        return null;
    }
}

