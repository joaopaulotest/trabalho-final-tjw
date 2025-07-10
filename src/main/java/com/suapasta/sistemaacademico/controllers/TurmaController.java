package com.suapasta.sistemaacademico.controllers;

import com.suapasta.sistemaacademico.entities.Turma;
import com.suapasta.sistemaacademico.entities.Disciplina;
import com.suapasta.sistemaacademico.entities.Professor;
import com.suapasta.sistemaacademico.repositories.TurmaRepository;
import com.suapasta.sistemaacademico.repositories.DisciplinaRepository;
import com.suapasta.sistemaacademico.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações relacionadas às turmas
 * Fornece endpoints para CRUD completo de turmas
 */
@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Cadastro de Turma
     * POST /turmas
     * Cria uma nova turma no sistema
     */
    @PostMapping
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody Turma turma) {
        try {
            // Verifica se a disciplina e professor existem
            if (turma.getDisciplina() != null && turma.getDisciplina().getId() != null) {
                Optional<Disciplina> disciplina = disciplinaRepository.findById(turma.getDisciplina().getId());
                if (!disciplina.isPresent()) {
                    return ResponseEntity.badRequest().build();
                }
                turma.setDisciplina(disciplina.get());
            }
            
            if (turma.getProfessor() != null && turma.getProfessor().getId() != null) {
                Optional<Professor> professor = professorRepository.findById(turma.getProfessor().getId());
                if (!professor.isPresent()) {
                    return ResponseEntity.badRequest().build();
                }
                turma.setProfessor(professor.get());
            }
            
            Turma turmaSalva = turmaRepository.save(turma);
            return ResponseEntity.ok(turmaSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Edição de Turma
     * PUT /turmas/{id}
     * Atualiza os dados de uma turma existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Turma> editarTurma(@PathVariable Long id, @RequestBody Turma turmaAtualizada) {
        Optional<Turma> turmaExistente = turmaRepository.findById(id);
        
        if (turmaExistente.isPresent()) {
            Turma turma = turmaExistente.get();
            turma.setNome(turmaAtualizada.getNome());
            
            // Atualiza disciplina se fornecida
            if (turmaAtualizada.getDisciplina() != null && turmaAtualizada.getDisciplina().getId() != null) {
                Optional<Disciplina> disciplina = disciplinaRepository.findById(turmaAtualizada.getDisciplina().getId());
                if (disciplina.isPresent()) {
                    turma.setDisciplina(disciplina.get());
                }
            }
            
            // Atualiza professor se fornecido
            if (turmaAtualizada.getProfessor() != null && turmaAtualizada.getProfessor().getId() != null) {
                Optional<Professor> professor = professorRepository.findById(turmaAtualizada.getProfessor().getId());
                if (professor.isPresent()) {
                    turma.setProfessor(professor.get());
                }
            }
            
            Turma turmaSalva = turmaRepository.save(turma);
            return ResponseEntity.ok(turmaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remoção de Turma
     * DELETE /turmas/{id}
     * Remove uma turma do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTurma(@PathVariable Long id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Consulta de Turmas
     * GET /turmas
     * Lista todas as turmas cadastradas
     */
    @GetMapping
    public ResponseEntity<List<Turma>> listarTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        return ResponseEntity.ok(turmas);
    }

    /**
     * GET /turmas/{id}
     * Busca uma turma específica pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        
        if (turma.isPresent()) {
            return ResponseEntity.ok(turma.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 