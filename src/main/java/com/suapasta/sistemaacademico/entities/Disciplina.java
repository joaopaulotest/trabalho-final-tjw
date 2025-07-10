package com.suapasta.sistemaacademico.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa uma disciplina no sistema acadêmico
 * Contém informações como nome, carga horária e ementa
 */
@Entity
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da disciplina
    private String nome;
    
    // Carga horária em horas
    private int cargaHoraria;

    // Ementa da disciplina (resumo do conteúdo)
    private String ementa;

    // Construtores
    public Disciplina() {}

    public Disciplina(String nome, int cargaHoraria, String ementa) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.ementa = ementa;
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
    
    public int getCargaHoraria() { 
        return cargaHoraria; 
    }
    
    public void setCargaHoraria(int cargaHoraria) { 
        this.cargaHoraria = cargaHoraria; 
    }
    
    public String getEmenta() { 
        return ementa; 
    }
    
    public void setEmenta(String ementa) { 
        this.ementa = ementa; 
    }
} 