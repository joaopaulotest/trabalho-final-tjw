package com.suapasta.sistemaacademico.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa uma turma no sistema acadêmico
 * Relaciona uma disciplina com um professor e tem um nome identificador
 */
@Entity
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com Disciplina (muitas turmas para uma disciplina)
    @ManyToOne
    private Disciplina disciplina;

    // Relacionamento com Professor (muitas turmas para um professor)
    @ManyToOne
    private Professor professor;

    // Nome/identificação da turma (ex: "2024.1-A", "Noturno", etc.)
    private String nome;
    
    // Capacidade máxima da turma (para validação de lotação - HU20)
    private Integer capacidade = 40; // valor padrão

    // Construtores
    public Turma() {}

    public Turma(Disciplina disciplina, Professor professor, String nome) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.nome = nome;
    }
    
    public Turma(Disciplina disciplina, Professor professor, String nome, Integer capacidade) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public Disciplina getDisciplina() { 
        return disciplina; 
    }
    
    public void setDisciplina(Disciplina disciplina) { 
        this.disciplina = disciplina; 
    }
    
    public Professor getProfessor() { 
        return professor; 
    }
    
    public void setProfessor(Professor professor) { 
        this.professor = professor; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public Integer getCapacidade() { 
        return capacidade; 
    }
    
    public void setCapacidade(Integer capacidade) { 
        this.capacidade = capacidade; 
    }
} 