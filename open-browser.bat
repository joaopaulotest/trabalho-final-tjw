@echo off
echo Aguardando o sistema inicializar...
timeout /t 10 /nobreak >nul

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
pause >nul 