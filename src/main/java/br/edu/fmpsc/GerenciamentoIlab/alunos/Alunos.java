package br.edu.fmpsc.GerenciamentoIlab.alunos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.fmpsc.GerenciamentoIlab.projetos.Projeto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    
    @ManyToMany(mappedBy = "alunos")
    private List<Projeto> projetos = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}
