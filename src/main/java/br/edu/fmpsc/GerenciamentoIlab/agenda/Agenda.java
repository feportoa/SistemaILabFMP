package br.edu.fmpsc.GerenciamentoIlab.agenda;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity(name = "tb_agenda")
public class Agenda {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String titulo, descricao;
    private LocalDate data;
    
    @Transient
    private List<UUID> projetos = new ArrayList<>();
}
