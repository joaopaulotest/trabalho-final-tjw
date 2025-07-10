package com.suapasta.sistemaacademico.controllers;

import com.suapasta.sistemaacademico.entities.Disciplina;
import com.suapasta.sistemaacademico.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gerenciar operações relacionadas às disciplinas
 * Fornece endpoints para CRUD completo de disciplinas
 */
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    /**
     * Cadastro de Disciplina
     * POST /disciplinas
     * Cria uma nova disciplina no sistema
     */
    @PostMapping
    public ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody Disciplina disciplina) {
        try {
            Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
            return ResponseEntity.ok(disciplinaSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Edição de Disciplina
     * PUT /disciplinas/{id}
     * Atualiza os dados de uma disciplina existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> editarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.findById(id);
        
        if (disciplinaExistente.isPresent()) {
            Disciplina disciplina = disciplinaExistente.get();
            disciplina.setNome(disciplinaAtualizada.getNome());
            disciplina.setCargaHoraria(disciplinaAtualizada.getCargaHoraria());
            disciplina.setEmenta(disciplinaAtualizada.getEmenta());
            
            Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
            return ResponseEntity.ok(disciplinaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remoção de Disciplina
     * DELETE /disciplinas/{id}
     * Remove uma disciplina do sistema
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDisciplina(@PathVariable Long id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Consulta de Disciplinas
     * GET /disciplinas
     * Lista todas as disciplinas cadastradas
     */
    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        return ResponseEntity.ok(disciplinas);
    }

    /**
     * GET /disciplinas/{id}
     * Busca uma disciplina específica pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable Long id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        
        if (disciplina.isPresent()) {
            return ResponseEntity.ok(disciplina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 