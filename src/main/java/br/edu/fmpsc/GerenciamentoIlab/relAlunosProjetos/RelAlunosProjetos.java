package br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "rel_alunos_projetos")
public class RelAlunosProjetos {
    // Ja passei raiva demais com o @ManyToMany
    // Por isso fiz essa classe, funciona que é uma beleza

    @Id
    @GeneratedValue(generator = "UUID") // O @Entity obriga a ter um @Id
    private UUID projetoId;
    private UUID alunoId;
}
