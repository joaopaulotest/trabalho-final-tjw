# Sistema de Gestão Acadêmica

Este é um sistema de gestão acadêmica desenvolvido em Java com Spring Boot, que permite gerenciar alunos, professores, disciplinas, turmas e matrículas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Maven**

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/suapasta/sistemaacademico/
│   │       ├── SistemaAcademicoApplication.java
│   │       ├── controllers/
│   │       │   ├── AlunoController.java
│   │       │   ├── ProfessorController.java
│   │       │   ├── DisciplinaController.java
│   │       │   ├── TurmaController.java
│   │       │   └── MatriculaController.java
│   │       ├── entities/
│   │       │   ├── Aluno.java
│   │       │   ├── Professor.java
│   │       │   ├── Disciplina.java
│   │       │   ├── Turma.java
│   │       │   └── Matricula.java
│   │       └── repositories/
│   │           ├── AlunoRepository.java
│   │           ├── ProfessorRepository.java
│   │           ├── DisciplinaRepository.java
│   │           ├── TurmaRepository.java
│   │           └── MatriculaRepository.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

## Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior (ou Maven Daemon - mvnd)

### Passos para Execução

1. **Clone ou baixe o projeto**

2. **Opção 1 - Usando o script automático (Recomendado):**
   - **Windows (CMD)**: Clique duas vezes no arquivo `run.bat`
   - **Windows (PowerShell)**: Clique com botão direito em `run.ps1` e selecione "Executar com PowerShell"
   - Os scripts detectarão automaticamente se você tem mvnd ou mvn instalado

3. **Opção 2 - Usando o terminal:**
   - Abra o terminal na pasta do projeto
   - Execute um dos comandos:
   ```bash
   mvnd spring-boot:run
   ```
   ou
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação:**
   - API REST: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console

## Endpoints da API

### Alunos
- `GET /alunos` - Lista todos os alunos
- `GET /alunos/{id}` - Busca aluno por ID
- `POST /alunos` - Cadastra novo aluno
- `PUT /alunos/{id}` - Atualiza aluno
- `DELETE /alunos/{id}` - Remove aluno

### Professores
- `GET /professores` - Lista todos os professores
- `GET /professores/{id}` - Busca professor por ID
- `POST /professores` - Cadastra novo professor
- `PUT /professores/{id}` - Atualiza professor
- `DELETE /professores/{id}` - Remove professor

### Disciplinas
- `GET /disciplinas` - Lista todas as disciplinas
- `GET /disciplinas/{id}` - Busca disciplina por ID
- `POST /disciplinas` - Cadastra nova disciplina
- `PUT /disciplinas/{id}` - Atualiza disciplina
- `DELETE /disciplinas/{id}` - Remove disciplina

### Turmas
- `GET /turmas` - Lista todas as turmas
- `GET /turmas/{id}` - Busca turma por ID
- `POST /turmas` - Cadastra nova turma
- `PUT /turmas/{id}` - Atualiza turma
- `DELETE /turmas/{id}` - Remove turma

### Matrículas
- `GET /matriculas` - Lista todas as matrículas
- `GET /matriculas/{id}` - Busca matrícula por ID
- `POST /matriculas` - Cadastra nova matrícula
- `PUT /matriculas/{id}` - Atualiza matrícula
- `DELETE /matriculas/{id}` - Remove matrícula

## Exemplos de Uso

### Cadastrar um Aluno
```bash
curl -X POST http://localhost:8080/alunos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "matricula": "2024001"
  }'
```

### Cadastrar um Professor
```bash
curl -X POST http://localhost:8080/professores \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Santos",
    "area": "Matemática"
  }'
```

### Cadastrar uma Disciplina
```bash
curl -X POST http://localhost:8080/disciplinas \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Cálculo I",
    "cargaHoraria": 60,
    "ementa": "Limites, derivadas e aplicações"
  }'
```

### Cadastrar uma Turma
```bash
curl -X POST http://localhost:8080/turmas \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "2024.1-A",
    "disciplina": {"id": 1},
    "professor": {"id": 1}
  }'
```

### Cadastrar uma Matrícula
```bash
curl -X POST http://localhost:8080/matriculas \
  -H "Content-Type: application/json" \
  -d '{
    "situacao": "ativo",
    "aluno": {"id": 1},
    "turma": {"id": 1}
  }'
```

## Banco de Dados

O projeto utiliza o H2 Database em memória, que é ideal para desenvolvimento e testes. Para acessar o console do banco:

1. Acesse: http://localhost:8080/h2-console
2. Use as seguintes configurações:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: (deixe em branco)

## Funcionalidades Implementadas

### Histórias de Usuário (HU)

- **HU1** - Cadastro de Aluno 
- **HU2** - Edição de Aluno 
- **HU3** - Remoção de Aluno 
- **HU4** - Consulta de Alunos 

Além disso, foram implementadas funcionalidades similares para:
- Professores
- Disciplinas
- Turmas
- Matrículas

## Configurações

As configurações do projeto estão no arquivo `application.properties`:

- **Porta do servidor**: 8080
- **Banco de dados**: H2 em memória
- **JPA**: Configurado para criar/atualizar tabelas automaticamente

## Próximos Passos

Para expandir o sistema, você pode:

1. Adicionar validações mais robustas
2. Implementar autenticação e autorização
3. Criar uma interface web (frontend)
4. Adicionar relatórios e estatísticas
5. Implementar testes automatizados
6. Migrar para um banco de dados persistente (MySQL, PostgreSQL)

## Sobre o Maven Daemon (mvnd)

Este projeto pode ser executado tanto com Maven tradicional quanto com Maven Daemon (mvnd). O mvnd é uma versão mais rápida do Maven que mantém um daemon em execução para acelerar as compilações.

### Verificando sua instalação:
- **Maven tradicional**: `mvn -version`
- **Maven Daemon**: `mvnd -version`

### Comandos equivalentes:
- `mvn clean compile` → `mvnd clean compile`
- `mvn spring-boot:run` → `mvnd spring-boot:run`
- `mvn clean install` → `mvnd clean install`

## Suporte

Se você tiver dúvidas ou encontrar problemas, verifique:

1. Se o Java 17 está instalado: `java -version`
2. Se o Maven está instalado: `mvn -version` ou `mvnd -version`
3. Se a porta 8080 está livre
4. Os logs da aplicação no console

---

**Desenvolvido por João Paulo Calixto da Silva** 