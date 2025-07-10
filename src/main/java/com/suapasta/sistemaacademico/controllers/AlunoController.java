package com.suapasta.sistemaacademico.controllers;

import com.suapasta.sistemaacademico.entities.Aluno;
import com.suapasta.sistemaacademico.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações relacionadas aos alunos
 * Fornece endpoints para CRUD completo de alunos
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    /**
     * HU1 - Cadastro de Aluno
     * POST /alunos
     * Cria um novo aluno no sistema
     */
    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        try {
            Aluno alunoSalvo = alunoRepository.save(aluno);
            return ResponseEntity.ok(alunoSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * HU2 - Edição de Aluno
     * PUT /alunos/{id}
     * Atualiza os dados de um aluno existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> editarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id);
        
        if (alunoExistente.isPresent()) {
            Aluno aluno = alunoExistente.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setMatricula(alunoAtualizado.getMatricula());
            
            Aluno alunoSalvo = alunoRepository.save(aluno);
            return ResponseEntity.ok(alunoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * HU3 - Remoção de Aluno
     * DELETE /alunos/{id}
     * Remove um aluno do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(@PathVariable Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * HU4 - Consulta de Alunos
     * GET /alunos
     * Lista todos os alunos cadastrados
     */
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    /**
     * GET /alunos/{id}
     * Busca um aluno específico pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 