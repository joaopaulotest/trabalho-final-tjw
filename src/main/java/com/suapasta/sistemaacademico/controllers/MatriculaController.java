package com.suapasta.sistemaacademico.controllers;

import com.suapasta.sistemaacademico.entities.Matricula;
import com.suapasta.sistemaacademico.entities.Aluno;
import com.suapasta.sistemaacademico.entities.Turma;
import com.suapasta.sistemaacademico.repositories.MatriculaRepository;
import com.suapasta.sistemaacademico.repositories.AlunoRepository;
import com.suapasta.sistemaacademico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações relacionadas às matrículas
 * Fornece endpoints para CRUD completo de matrículas
 */
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;

    /**
     * Cadastro de Matrícula
     * POST /matriculas
     * Cria uma nova matrícula no sistema
     */
    @PostMapping
    public ResponseEntity<Matricula> cadastrarMatricula(@RequestBody Matricula matricula) {
        try {
            // Verifica se o aluno e turma existem
            if (matricula.getAluno() != null && matricula.getAluno().getId() != null) {
                Optional<Aluno> aluno = alunoRepository.findById(matricula.getAluno().getId());
                if (!aluno.isPresent()) {
                    return ResponseEntity.badRequest().build();
                }
                matricula.setAluno(aluno.get());
            }
            
            if (matricula.getTurma() != null && matricula.getTurma().getId() != null) {
                Optional<Turma> turma = turmaRepository.findById(matricula.getTurma().getId());
                if (!turma.isPresent()) {
                    return ResponseEntity.badRequest().build();
                }
                matricula.setTurma(turma.get());
                
                // HU20 - Validação de lotação da turma
                List<Matricula> matriculasExistentes = matriculaRepository.findByTurmaId(turma.get().getId());
                if (matriculasExistentes.size() >= turma.get().getCapacidade()) {
                    return ResponseEntity.badRequest().build(); // Turma lotada
                }
            }
            
            Matricula matriculaSalva = matriculaRepository.save(matricula);
            return ResponseEntity.ok(matriculaSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Edição de Matrícula
     * PUT /matriculas/{id}
     * Atualiza os dados de uma matrícula existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> editarMatricula(@PathVariable Long id, @RequestBody Matricula matriculaAtualizada) {
        Optional<Matricula> matriculaExistente = matriculaRepository.findById(id);
        
        if (matriculaExistente.isPresent()) {
            Matricula matricula = matriculaExistente.get();
            matricula.setSituacao(matriculaAtualizada.getSituacao());
            
            // Atualiza aluno se fornecido
            if (matriculaAtualizada.getAluno() != null && matriculaAtualizada.getAluno().getId() != null) {
                Optional<Aluno> aluno = alunoRepository.findById(matriculaAtualizada.getAluno().getId());
                if (aluno.isPresent()) {
                    matricula.setAluno(aluno.get());
                }
            }
            
            // Atualiza turma se fornecida
            if (matriculaAtualizada.getTurma() != null && matriculaAtualizada.getTurma().getId() != null) {
                Optional<Turma> turma = turmaRepository.findById(matriculaAtualizada.getTurma().getId());
                if (turma.isPresent()) {
                    matricula.setTurma(turma.get());
                }
            }
            
            Matricula matriculaSalva = matriculaRepository.save(matricula);
            return ResponseEntity.ok(matriculaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remoção de Matrícula
     * DELETE /matriculas/{id}
     * Remove uma matrícula do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerMatricula(@PathVariable Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Consulta de Matrículas
     * GET /matriculas
     * Lista todas as matrículas cadastradas
     */
    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        List<Matricula> matriculas = matriculaRepository.findAll();
        return ResponseEntity.ok(matriculas);
    }

    /**
     * GET /matriculas/{id}
     * Busca uma matrícula específica pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarMatriculaPorId(@PathVariable Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        
        if (matricula.isPresent()) {
            return ResponseEntity.ok(matricula.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * HU20 - Consulta de Matrículas por Aluno
     * GET /matriculas/por-aluno/{alunoId}
     * Lista todas as matrículas de um aluno específico
     */
    @GetMapping("/por-aluno/{alunoId}")
    public ResponseEntity<List<Matricula>> listarMatriculasPorAluno(@PathVariable Long alunoId) {
        List<Matricula> matriculas = matriculaRepository.findByAlunoId(alunoId);
        return ResponseEntity.ok(matriculas);
    }

    /**
     * HU20 - Consulta de Matrículas por Turma
     * GET /matriculas/por-turma/{turmaId}
     * Lista todas as matrículas de uma turma específica
     */
    @GetMapping("/por-turma/{turmaId}")
    public ResponseEntity<List<Matricula>> listarMatriculasPorTurma(@PathVariable Long turmaId) {
        List<Matricula> matriculas = matriculaRepository.findByTurmaId(turmaId);
        return ResponseEntity.ok(matriculas);
    }

    /**
     * HU20 - Consulta de Matrículas por Situação
     * GET /matriculas/por-situacao/{situacao}
     * Lista todas as matrículas com uma situação específica
     */
    @GetMapping("/por-situacao/{situacao}")
    public ResponseEntity<List<Matricula>> listarMatriculasPorSituacao(@PathVariable String situacao) {
        List<Matricula> matriculas = matriculaRepository.findBySituacao(situacao);
        return ResponseEntity.ok(matriculas);
    }
} 