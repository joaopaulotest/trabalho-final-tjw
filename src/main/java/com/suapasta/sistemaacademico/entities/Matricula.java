package com.suapasta.sistemaacademico.entities;

import jakarta.persistence.*;

/**
 * Entidade que representa uma matrícula no sistema acadêmico
 * Relaciona um aluno com uma turma e controla a situação da matrícula
 */
@Entity
public class Matricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com Aluno (muitas matrículas para um aluno)
    @ManyToOne
    private Aluno aluno;

    // Relacionamento com Turma (muitas matrículas para uma turma)
    @ManyToOne
    private Turma turma;

    // Situação da matrícula (ativo, cancelado, trancado, etc.)
    private String situacao;

    // Construtores
    public Matricula() {}

    public Matricula(Aluno aluno, Turma turma, String situacao) {
        this.aluno = aluno;
        this.turma = turma;
        this.situacao = situacao;
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public Aluno getAluno() { 
        return aluno; 
    }
    
    public void setAluno(Aluno aluno) { 
        this.aluno = aluno; 
    }
    
    public Turma getTurma() { 
        return turma; 
    }
    
    public void setTurma(Turma turma) { 
        this.turma = turma; 
    }
    
    public String getSituacao() { 
        return situacao; 
    }
    
    public void setSituacao(String situacao) { 
        this.situacao = situacao; 
    }
} 