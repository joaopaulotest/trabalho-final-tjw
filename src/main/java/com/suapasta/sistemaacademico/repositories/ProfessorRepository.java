package com.suapasta.sistemaacademico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suapasta.sistemaacademico.entities.Professor;

/**
 * Repository responsável por acessar o banco de dados para a entidade Professor
 * Fornece métodos básicos de CRUD (Create, Read, Update, Delete)
 */
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    // Aqui podemos adicionar métodos de consulta específicos, se precisar
    // Por exemplo:
    // List<Professor> findByArea(String area);
    // Professor findByNome(String nome);
} 