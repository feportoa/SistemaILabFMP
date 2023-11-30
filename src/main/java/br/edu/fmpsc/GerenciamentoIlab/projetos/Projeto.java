package br.edu.fmpsc.GerenciamentoIlab.projetos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity(name = "tb_projetos")
public class Projeto {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome, descricao;
    private LocalDate datas; // Provavelmente vai ser atualizado quando tiver a classe agendas
    private boolean isAtivo;

    @Transient // Transient nao eh passado para o banco de dados, mas eh aceito no JSON
    private List<UUID> alunos = new ArrayList<>(); // Passei um UUID ja que o banco nao tem o tipo Alunos

    @CreationTimestamp
    private LocalDateTime createdAt;
}
