package com.suapasta.sistemaacademico.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para a página inicial do sistema
 */
@RestController
public class HomeController {

    /**
     * Página inicial do sistema
     * GET /
     */
    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Sistema de Gestão Acadêmica</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        max-width: 800px;
                        margin: 0 auto;
                        padding: 20px;
                        background-color: #f5f5f5;
                    }
                    .container {
                        background-color: white;
                        padding: 30px;
                        border-radius: 10px;
                        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                    }
                    h1 {
                        color: #2c3e50;
                        text-align: center;
                        margin-bottom: 30px;
                    }
                    .endpoint {
                        background-color: #ecf0f1;
                        padding: 15px;
                        margin: 10px 0;
                        border-radius: 5px;
                        border-left: 4px solid #3498db;
                    }
                    .method {
                        font-weight: bold;
                        color: #e74c3c;
                    }
                    .url {
                        font-family: monospace;
                        color: #2980b9;
                    }
                    .description {
                        color: #7f8c8d;
                        margin-top: 5px;
                    }
                    .section {
                        margin: 30px 0;
                    }
                    .section h2 {
                        color: #34495e;
                        border-bottom: 2px solid #3498db;
                        padding-bottom: 10px;
                    }
                    .links {
                        text-align: center;
                        margin: 30px 0;
                    }
                    .links a {
                        display: inline-block;
                        margin: 10px;
                        padding: 10px 20px;
                        background-color: #3498db;
                        color: white;
                        text-decoration: none;
                        border-radius: 5px;
                        transition: background-color 0.3s;
                    }
                    .links a:hover {
                        background-color: #2980b9;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Sistema de Gestão Acadêmica</h1>
                    
                    <div class="links">
                        <a href="/h2-console" target="_blank">Console do Banco de Dados</a>
                        <a href="/alunos" target="_blank">API Alunos</a>
                        <a href="/professores" target="_blank">API Professores</a>
                        <a href="/disciplinas" target="_blank">API Disciplinas</a>
                    </div>
                    
                    <div class="section">
                        <h2>Endpoints da API</h2>
                        
                        <div class="endpoint">
                            <div><span class="method">GET</span> <span class="url">/alunos</span></div>
                            <div class="description">Lista todos os alunos cadastrados</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">POST</span> <span class="url">/alunos</span></div>
                            <div class="description">Cadastra um novo aluno</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">GET</span> <span class="url">/professores</span></div>
                            <div class="description">Lista todos os professores</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">POST</span> <span class="url">/professores</span></div>
                            <div class="description">Cadastra um novo professor</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">GET</span> <span class="url">/disciplinas</span></div>
                            <div class="description">Lista todas as disciplinas</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">POST</span> <span class="url">/disciplinas</span></div>
                            <div class="description">Cadastra uma nova disciplina</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">GET</span> <span class="url">/turmas</span></div>
                            <div class="description">Lista todas as turmas</div>
                        </div>
                        
                        <div class="endpoint">
                            <div><span class="method">GET</span> <span class="url">/matriculas</span></div>
                            <div class="description">Lista todas as matrículas</div>
                        </div>
                    </div>
                    
                    <div class="section">
                        <h2>Como Testar</h2>
                        <p>Use ferramentas como <strong>Postman</strong>, <strong>Insomnia</strong> ou <strong>curl</strong> para testar os endpoints.</p>
                        
                        <h3>Exemplo de cadastro de aluno:</h3>
                        <div class="endpoint">
                            <div><span class="method">POST</span> <span class="url">/alunos</span></div>
                            <div class="description">
                                Body (JSON): {"nome": "João Silva", "matricula": "2024001"}
                            </div>
                        </div>
                    </div>
                    
                    <div class="section">
                        <h2>Status do Sistema</h2>
                        <p style="color: #27ae60; font-weight: bold;">✅ Sistema funcionando corretamente!</p>
                        <p>Servidor rodando na porta 8080</p>
                        <p>Banco de dados H2 em memória ativo</p>
                    </div>
                </div>
            </body>
            </html>
            """;
    }
} 