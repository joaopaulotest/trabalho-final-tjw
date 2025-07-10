package com.suapasta.sistemaacademico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suapasta.sistemaacademico.entities.Matricula;

/**
 * Repository responsável por acessar o banco de dados para a entidade Matricula
 * Fornece métodos básicos de CRUD (Create, Read, Update, Delete)
 */
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
    // Aqui podemos adicionar métodos de consulta específicos, se precisar
    // Por exemplo:
    // List<Matricula> findByAlunoId(Long alunoId);
    // List<Matricula> findByTurmaId(Long turmaId);
    // List<Matricula> findBySituacao(String situacao);
} 