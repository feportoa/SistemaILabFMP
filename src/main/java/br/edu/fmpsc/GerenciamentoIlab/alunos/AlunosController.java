package br.edu.fmpsc.GerenciamentoIlab.alunos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aluno")
public class AlunosController {
    
    @Autowired
    private IAlunoRepository alunoRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody Alunos aluno)
    {
        var alunoEmail = this.alunoRepository.findByEmail(aluno.getEmail());

        if(alunoEmail != null){
            System.out.println(alunoEmail);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aluno.getEmail() + " já existe.");
        }

        var alunoCreated = this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreated);
    }

    // Ja nao sei mais o que ta acontecendo aqui
    @GetMapping("")
    public List<Alunos> list() {
        return alunoRepository.findAll();
    }
}
