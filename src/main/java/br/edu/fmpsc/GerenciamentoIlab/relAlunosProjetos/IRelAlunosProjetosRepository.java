package br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRelAlunosProjetosRepository extends JpaRepository<RelAlunosProjetos, UUID>{
    RelAlunosProjetos findByProjetoId(UUID projeto_id);
    RelAlunosProjetos findByAlunoId(UUID aluno_id);
    Object findByProjetoIdAndAlunoId(UUID projetoId, UUID alunoId);
}
