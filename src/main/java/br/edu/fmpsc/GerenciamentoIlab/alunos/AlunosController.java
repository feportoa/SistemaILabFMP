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

import br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos.RelAlunosProjetosController;

@RestController
@RequestMapping("/aluno")
public class AlunosController {

    private final RelAlunosProjetosController relAlunosProjetosController;

    @Autowired
    public AlunosController(RelAlunosProjetosController relAlunosProjetosController){
        this.relAlunosProjetosController = relAlunosProjetosController;
    }
    
    @Autowired
    private IAlunoRepository alunoRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody Alunos aluno)
    {
        var alunoEmail = this.alunoRepository.findByEmail(aluno.getEmail());

        if(alunoEmail != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aluno.getEmail() + " já existe.");
        }

        var alunoCreated = this.alunoRepository.save(aluno);
        relAlunosProjetosController.createRel(alunoCreated.getProjetos(), alunoCreated.getId()); // Sempre colocar depois do saved pro id nao bugar

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreated);
    }

    // Ja nao sei mais o que ta acontecendo aqui
    @GetMapping("")
    public List<Alunos> list() {
        return alunoRepository.findAll();
    }
}
