package br.edu.fmpsc.GerenciamentoIlab.projetos;

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
@RequestMapping("/projeto")
public class ProjetoController {

    private final RelAlunosProjetosController relAlunosProjetosController; 

    @Autowired
    public ProjetoController(RelAlunosProjetosController relAlunosProjetosController) {
        this.relAlunosProjetosController = relAlunosProjetosController; // Inicializando a minha relController como uma relController (honestamente, nao entendi, mas funcionou)
    }
    @Autowired
    private IProjetoRepository projetoRepository;

    @PostMapping("")
    public ResponseEntity createProjeto(@RequestBody Projeto projeto)
    {
        var projetoNome = this.projetoRepository.findByNome(projeto.getNome());

        if(projetoNome != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(projeto.getNome() + " já existe.");
        }

        var projetoCreated = this.projetoRepository.save(projeto);
        relAlunosProjetosController.createRel(projetoCreated.getId(), projetoCreated.getAlunos()); // Sempre colocar depois do saved pro id nao bugar
        
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoCreated);
    }


    // FIX Se um projeto tiver uma relacao com aluno, os Gets param de funcionar (Aqui ou no AlunoController)
    @GetMapping("")
    public List<Projeto> list()
    {
        return projetoRepository.findAll();
    }
}
