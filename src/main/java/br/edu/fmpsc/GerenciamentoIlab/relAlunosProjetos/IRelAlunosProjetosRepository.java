package br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRelAlunosProjetosRepository extends JpaRepository<RelAlunosProjetos, UUID>{
    RelAlunosProjetos findByProjetoId(UUID projeto_id);
    List<RelAlunosProjetos> findByAlunoId(UUID aluno_id);
}
