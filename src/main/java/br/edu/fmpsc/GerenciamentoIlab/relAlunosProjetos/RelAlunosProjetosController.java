package br.edu.fmpsc.GerenciamentoIlab.relAlunosProjetos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos/projetos")
public class RelAlunosProjetosController {

    @Autowired
    private IRelAlunosProjetosRepository relRepository;

    @PostMapping("")
    public ResponseEntity createRel(@RequestBody RelAlunosProjetos rel)
    {
        var projetoId = this.relRepository.findByProjetoId(rel.getProjetoId());
        var alunoId = this.relRepository.findByAlunoId(rel.getAlunoId());

        if(projetoId != null && alunoId != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Projeto e Aluno ja estao relacionados");
        }

        var relCreated = this.relRepository.save(rel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(relCreated);
    }

    // Mesmo metodo que o de cima, mas preparado para ser chamado no ProjetoController
    // Por que nao precisa de @PostMapping("")? 🤔
    public ResponseEntity createRel(UUID projeto_id, List<UUID> alunos_id)
    {
        int totalAlunos = alunos_id.size();
        int alunosCarregados = 0; // Começa como 0 pq null ia dar problema
        List<RelAlunosProjetos> relList;

        for(UUID a : alunos_id){
            relList = this.list();

            if(relList.indexOf(new RelAlunosProjetos(projeto_id, a)) == -1){ // Se nao tiver nem o projeto e nem o aluno atual, salva no banco
                RelAlunosProjetos rel = new RelAlunosProjetos(projeto_id, a); // Como o RelAlunosProjeto nao foi passado nos parametros, passamos ele por aqui
                this.relRepository.save(rel);
            } else continue;
        }
        if(alunosCarregados > 0){
            return ResponseEntity.status(HttpStatus.CREATED).body(alunosCarregados + "/" + totalAlunos + " carregados no banco com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nenhum aluno carregado no banco de dados");
    }

    // Agora eh pra ser usado no AlunosController
    public ResponseEntity createRel(List<UUID> projetos_id, UUID aluno_id)
    {
        if(projetos_id != null && projetos_id.size() > 0){
            int totalAlunos = projetos_id.size();
            int alunosCarregados = 0; // Começa como 0 pq null ia dar problema
            List<RelAlunosProjetos> relList;
            
            for(UUID p : projetos_id){
                relList = this.list(); // Com certeza nao eh a melhor opcao, assim como eu nao sou o melhor programador do mundo

                if(relList.indexOf(new RelAlunosProjetos(p, aluno_id)) == -1){ // Se nao tiver nem o projeto e nem o aluno atual, salva no banco
                    RelAlunosProjetos rel = new RelAlunosProjetos(p, aluno_id); // Como o RelAlunosProjeto nao foi passado nos parametros, passamos ele por aqui
                    this.relRepository.save(rel);
                }
            }
            if(alunosCarregados > 0){
                return ResponseEntity.status(HttpStatus.CREATED).body(alunosCarregados + "/" + totalAlunos + " carregados no banco com sucesso.");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nenhum aluno carregado no banco de dados");
    }

    @GetMapping("")
    public List<RelAlunosProjetos> list(){
        return relRepository.findAll();
    }
}
