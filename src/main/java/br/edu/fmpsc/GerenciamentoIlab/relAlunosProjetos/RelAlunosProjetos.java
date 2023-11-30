package br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rel_alunos_projetos")
public class RelAlunosProjetos {
    // Ja passei raiva demais com o @ManyToMany
    // Por isso fiz essa classe, funciona que é uma beleza

    @JsonIgnore // Nao queremos que isso apareca no JSON de jeito nenhum
    public RelAlunosProjetos(UUID projetoId, UUID alunoId){
        this.projetoId = projetoId;
        this.alunoId = alunoId;
    }

    public RelAlunosProjetos(){
    }

    @Id
    @GeneratedValue(generator = "long") // O @Entity obriga a ter um @Id
    private long id;

    private UUID projetoId;
    private UUID alunoId;
}
