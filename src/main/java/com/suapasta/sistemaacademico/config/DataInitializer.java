package com.suapasta.sistemaacademico.config;

import com.suapasta.sistemaacademico.entities.*;
import com.suapasta.sistemaacademico.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Inicializador de dados para carregar dados iniciais do sistema
 * Inclui o Professor Cornelli e dados de exemplo
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem dados para não duplicar
        if (alunoRepository.count() == 0) {
            carregarDadosIniciais();
        }
    }
    
    private void carregarDadosIniciais() {
        // HU5 - Cadastro do Professor Cornelli
        Professor cornelli = new Professor("Cornelli", "Tópico Java para Web");
        professorRepository.save(cornelli);
        
        // HU9 - Cadastro da Disciplina TJW
        Disciplina tjw = new Disciplina("TJW", 40, "Tópicos Java para Web");
        disciplinaRepository.save(tjw);
        
        // HU13 - Cadastro da Turma 2025.1 Manhã
        Turma turma = new Turma(tjw, cornelli, "2025.1 Manhã", 40);
        turmaRepository.save(turma);
        
        // HU1 - Cadastro de Aluno de exemplo
        Aluno aluno = new Aluno("João Silva", "2024001");
        alunoRepository.save(aluno);
        
        // HU17 - Cadastro de Matrícula de exemplo
        Matricula matricula = new Matricula(aluno, turma, "ativo");
        matriculaRepository.save(matricula);
        
        System.out.println("Dados iniciais carregados com sucesso!");
        System.out.println("Professor Cornelli cadastrado");
        System.out.println("Disciplina TJW cadastrada");
        System.out.println("Turma 2025.1 Manhã criada");
        System.out.println("Aluno João Silva matriculado");
    }
} 