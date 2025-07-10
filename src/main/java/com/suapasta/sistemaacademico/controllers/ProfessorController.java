package com.suapasta.sistemaacademico.controllers;

import com.suapasta.sistemaacademico.entities.Professor;
import com.suapasta.sistemaacademico.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações relacionadas aos professores
 * Fornece endpoints para CRUD completo de professores
 */
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Cadastro de Professor
     * POST /professores
     * Cria um novo professor no sistema
     */
    @PostMapping
    public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {
        try {
            Professor professorSalvo = professorRepository.save(professor);
            return ResponseEntity.ok(professorSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Edição de Professor
     * PUT /professores/{id}
     * Atualiza os dados de um professor existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Professor> editarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Optional<Professor> professorExistente = professorRepository.findById(id);
        
        if (professorExistente.isPresent()) {
            Professor professor = professorExistente.get();
            professor.setNome(professorAtualizado.getNome());
            professor.setArea(professorAtualizado.getArea());
            
            Professor professorSalvo = professorRepository.save(professor);
            return ResponseEntity.ok(professorSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remoção de Professor
     * DELETE /professores/{id}
     * Remove um professor do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProfessor(@PathVariable Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Consulta de Professores
     * GET /professores
     * Lista todos os professores cadastrados
     */
    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = professorRepository.findAll();
        return ResponseEntity.ok(professores);
    }

    /**
     * GET /professores/{id}
     * Busca um professor específico pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        
        if (professor.isPresent()) {
            return ResponseEntity.ok(professor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 