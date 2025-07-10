package com.suapasta.sistemaacademico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suapasta.sistemaacademico.entities.Turma;

/**
 * Repository responsável por acessar o banco de dados para a entidade Turma
 * Fornece métodos básicos de CRUD (Create, Read, Update, Delete)
 */
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
    // Aqui podemos adicionar métodos de consulta específicos, se precisar
    // Por exemplo:
    // List<Turma> findByDisciplinaId(Long disciplinaId);
    // List<Turma> findByProfessorId(Long professorId);
} 