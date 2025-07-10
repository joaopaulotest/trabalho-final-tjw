@echo off
echo Iniciando Sistema de Gestao Academica...
echo.

REM Verifica se o Java está instalado
java -version >nul 2>&1
if errorlevel 1 (
    echo ERRO: Java nao encontrado. Instale o Java 17 ou superior.
    pause
    exit /b 1
)

REM Tenta executar com mvnd primeiro
echo Tentando executar com Maven Daemon (mvnd)...
start /B mvnd spring-boot:run
if errorlevel 1 (
    echo Maven Daemon nao encontrado, tentando com Maven tradicional...
    start /B mvn spring-boot:run
    if errorlevel 1 (
        echo ERRO: Nenhum Maven encontrado. Instale o Maven ou Maven Daemon.
        pause
        exit /b 1
    )
)

echo.
echo Aguardando o sistema inicializar...
timeout /t 15 /nobreak >nul

echo Abrindo o navegador...
start http://localhost:8080

echo.
echo Sistema de Gestao Academica iniciado!
echo.
echo URLs disponiveis:
echo - Pagina inicial: http://localhost:8080
echo - Console H2: http://localhost:8080/h2-console
echo - API Alunos: http://localhost:8080/alunos
echo.
echo Pressione qualquer tecla para sair...
pause 