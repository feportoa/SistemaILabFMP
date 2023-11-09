package br.edu.fmpsc.GerenciamentoIlab.alunos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunosController {
    
    @Autowired
    private IAlunoRepository alunoRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody Alunos aluno)
    {
        var alunoEmail = this.alunoRepository.findByNome(aluno.getNome());

        if(alunoEmail != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aluno.getNome() + " já existe.");
        }

        var alunoCreated = this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreated);
        
    }

}
