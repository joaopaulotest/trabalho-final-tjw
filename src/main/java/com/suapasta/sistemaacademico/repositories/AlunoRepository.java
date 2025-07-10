package com.suapasta.sistemaacademico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suapasta.sistemaacademico.entities.Aluno;

/**
 * Repository responsável por acessar o banco de dados para a entidade Aluno
 * Fornece métodos básicos de CRUD (Create, Read, Update, Delete)
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    // Aqui podemos adicionar métodos de consulta específicos, se precisar
    // Por exemplo:
    // List<Aluno> findByNomeContaining(String nome);
    // Aluno findByMatricula(String matricula);
} 