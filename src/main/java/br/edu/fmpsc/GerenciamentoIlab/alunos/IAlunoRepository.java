package br.edu.fmpsc.GerenciamentoIlab.alunos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<Alunos, UUID> {
    Alunos findByid(UUID id);
    Alunos findByEmail(String email);
    Alunos findByNome(String nome);
    Alunos findByMatricula(int matricula); 
}
