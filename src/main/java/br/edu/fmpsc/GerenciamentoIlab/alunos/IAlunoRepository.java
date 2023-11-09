package br.edu.fmpsc.GerenciamentoIlab.alunos;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<Alunos, UUID> {
    List<Alunos> findByid(UUID id);
    /*List<Alunos>*/ Alunos findByEmail(String email);
    List<Alunos> findByNome(String nome);
    List<Alunos> findByMatricula(int matricula); 
    List<Alunos> findAll();
}
