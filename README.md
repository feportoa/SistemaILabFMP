# SistemaILabFMP

- [Historias de Usuário](#histórias-de-usuário)
- [APIs](#apis)
- [TODO List](#todo-list)

# Histórias de usuário

<br>Eu como coordenador do Ilab desejo um cadastro de alunos para gerenciar os alunos que  pertencem aos projetos do Ilab 
<br>Eu como coordenador do Ilab desejo um cadastro de projetos para gerenciar os projetos  cadastrados no Ilab 
<br>Eu como coordenador do Ilab desejo uma agenda de dias de trabalho/encontros por projeto para realizar as atividades na FMP 
<br>Eu como coordenador do Ilab desejo um relatório de presença dos integrantes de cada equipe  por semestre para emitir certificado de participação. 
<br>Eu como coordenador desejo realizar a chamada dos alunos nos encontros presenciais para ter  um controle de participação presencial <br>
<br>Tecnologia Utilizada 
<br>Java Spring Boot 
<br>Spring Data 
<br><br>Datas Importantes 
<br>Data de apresentação 27/11 valerá a nota de A3 apresentação parcial do produto.
<br>Data de apresentação 08/12/2023 nota de A1 apresentação final do produto  
<br>Equipe 1: Monique, Ricardo, Fernando Gabriel, Luis, Thuany, David, Mamadu 
<br>Equipe 2: Moriel, Fernando Freitas, Eduardo, Gabriel, Maurício, Welligton, Bruno Hospedagem no servidor 

# APIs

- **CREATE** User
    - Cria um usuario
- **GET** Users
    - Retorna todos os usuarios
- **CREATE** Agenda
    - Cria uma agenda
- **GET** Agendas
    - Retorna todas as agendas
- **CREATE** Aluno
    - Cria um aluno e relaciona com um projeto ou mais (se especificados)
- **GET** Aluno
    - Retorna todos os alunos
- **CREATE** Projeto
    - Cria um projeto e relaciona com um aluno ou mais (se especificados)
- **GET** Projetos
    - Retorna todos os projetos
- **CREATE** Rel Alunos-Projetos
    - Cria uma relacao entre um aluno e um projeto
- **GET** Rel Alunos-Projetos
    - Retorna todas as relacoes entre alunos e projetos.

# TODO List

Encontre a todo list no **[Trello](https://trello.com/b/nSPrY1xR/dev)**