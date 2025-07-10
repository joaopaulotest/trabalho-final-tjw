package com.suapasta.sistemaacademico.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa um professor no sistema acadêmico
 * Contém informações como nome e área de atuação
 */
@Entity
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome completo do professor
    private String nome;

    // Área de atuação do professor (ex: Matemática, História, etc.)
    private String area;

    // Construtores
    public Professor() {}

    public Professor(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public String getArea() { 
        return area; 
    }
    
    public void setArea(String area) { 
        this.area = area; 
    }
} 