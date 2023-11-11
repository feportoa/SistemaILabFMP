package br.edu.fmpsc.GerenciamentoIlab.users;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByNome(String nome);
    User findByid (UUID id);
    User findByEmail(String email);
}