package br.edu.fmpsc.GerenciamentoIlab.projetos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjetoRepository extends JpaRepository<Projeto, UUID>{
    Projeto findByid(UUID id);
    Projeto findByNome(String nome);
    Projeto findByDatas(LocalDateTime datas);
    Projeto findByIsAtivo(boolean isAtivo);

    List<Projeto> findAll();
}
