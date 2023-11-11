package br.edu.fmpsc.GerenciamentoIlab.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String email;
    private String senha;
    private String cnpj_cpf;
    private boolean isCoordenador;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
