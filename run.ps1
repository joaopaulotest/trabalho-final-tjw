Write-Host "Iniciando Sistema de Gestao Academica..." -ForegroundColor Green
Write-Host ""

# Verifica se o Java está instalado
try {
    $javaVersion = java -version 2>&1
    Write-Host "Java encontrado:" -ForegroundColor Green
    Write-Host $javaVersion[0] -ForegroundColor Yellow
} catch {
    Write-Host "ERRO: Java nao encontrado. Instale o Java 17 ou superior." -ForegroundColor Red
    Read-Host "Pressione Enter para sair"
    exit 1
}

Write-Host ""
Write-Host "Tentando executar com Maven Daemon (mvnd)..." -ForegroundColor Cyan

# Tenta executar com mvnd primeiro
try {
    Start-Process -FilePath "mvnd" -ArgumentList "spring-boot:run" -WindowStyle Hidden
} catch {
    Write-Host "Maven Daemon nao encontrado, tentando com Maven tradicional..." -ForegroundColor Yellow
    try {
        Start-Process -FilePath "mvn" -ArgumentList "spring-boot:run" -WindowStyle Hidden
    } catch {
        Write-Host "ERRO: Nenhum Maven encontrado. Instale o Maven ou Maven Daemon." -ForegroundColor Red
        Write-Host "Para instalar o Maven Daemon, visite: https://github.com/mvndaemon/mvnd" -ForegroundColor Yellow
        Read-Host "Pressione Enter para sair"
        exit 1
    }
}

Write-Host ""
Write-Host "Aguardando o sistema inicializar..." -ForegroundColor Cyan
Start-Sleep -Seconds 15

Write-Host "Abrindo o navegador..." -ForegroundColor Green
Start-Process "http://localhost:8080"

Write-Host ""
Write-Host "Sistema de Gestao Academica iniciado!" -ForegroundColor Green
Write-Host ""
Write-Host "URLs disponiveis:" -ForegroundColor Yellow
Write-Host "- Pagina inicial: http://localhost:8080" -ForegroundColor White
Write-Host "- Console H2: http://localhost:8080/h2-console" -ForegroundColor White
Write-Host "- API Alunos: http://localhost:8080/alunos" -ForegroundColor White
Write-Host ""
Read-Host "Pressione Enter para sair" 