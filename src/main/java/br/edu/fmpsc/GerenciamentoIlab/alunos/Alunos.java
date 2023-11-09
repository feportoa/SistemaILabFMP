package br.edu.fmpsc.GerenciamentoIlab.alunos;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_alunos")
public class Alunos {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String cpf, nome, email;
    private int matricula;
    private boolean isAtivo;
    // private Projeto[] projParticipa;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
