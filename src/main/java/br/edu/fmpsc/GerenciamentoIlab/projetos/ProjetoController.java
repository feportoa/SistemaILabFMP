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

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(projetoCreated);
    }


    // FIX Se um projeto tiver uma relacao com aluno, os Gets param de funcionar (Aqui ou no AlunoController)
    @GetMapping("")
    public List<Projeto> list()
    {
        return projetoRepository.findAll();
    }
}
