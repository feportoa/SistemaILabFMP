package br.edu.fmpsc.GerenciamentoIlab.agenda;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<Agenda, UUID>{
    Agenda findByData(LocalDate data);
    Agenda findByTitulo(String titulo);

    List<Agenda> findAll();
}
