package br.edu.fmpsc.GerenciamentoIlab.Pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.fmpsc.GerenciamentoIlab.alunos.Alunos;
import br.edu.fmpsc.GerenciamentoIlab.alunos.AlunosController;

@Controller
public class Pages {

    @Autowired
    private AlunosController alunosController;

    @PostMapping("/cadastrarAluno") // Faz o Post das informacoes da pagina de cadastro (só do aluno) e redireciona para a visualizacao de alunos
    public String cadastrarAluno(@ModelAttribute Alunos aluno){ // @ModelAttribute coleta o atributo atribuido no formCadastro()
        alunosController.create(aluno); // Cria um aluno no BD atraves do AlunosController
        return "redirect:/infoAluno"; // Redireciona para a pagina /infoAluno
    }

    @GetMapping("/infoAluno") // Faz um GET pra pagina informacoes_alunos
    public String pagina(Model model) {
        List<Alunos> alunos = alunosController.list(); // Coleta a lista de alunos
        model.addAttribute("alunos", alunos); // Adiciona um atributo na pagina "alunos" usando a variavel aluno (sendo utilizado no frontend)
        return "informacoes_alunos"; // Retorna a pagina informacoes_alunos.html (nao precisa botar ".html" no final)
    }

    @GetMapping("/cadastrar") // Faz um GET pra pagina cadastrar_alunos_projetos
    public String formCadastro(Model model) {
        model.addAttribute("aluno", new Alunos()); // Cria um atributo aluno que pode ser manipulado pra fazer cadastro (/cadastrarAluno)
        return "cadastrar_aluno_projeto";
    }
}
