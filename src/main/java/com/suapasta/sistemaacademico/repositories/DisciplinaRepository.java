package com.suapasta.sistemaacademico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.suapasta.sistemaacademico.entities.Disciplina;

/**
 * Repository responsável por acessar o banco de dados para a entidade Disciplina
 * Fornece métodos básicos de CRUD (Create, Read, Update, Delete)
 */
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
    // Aqui podemos adicionar métodos de consulta específicos, se precisar
    // Por exemplo:
    // List<Disciplina> findByCargaHorariaGreaterThan(int cargaHoraria);
    // Disciplina findByNome(String nome);
} 