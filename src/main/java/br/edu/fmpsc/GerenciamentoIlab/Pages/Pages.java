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

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Alunos aluno, Model model){
        alunosController.create(aluno);
        return "redirect:/pagina";
    }

    @GetMapping("/pagina")
    public String pagina(Model model) {
        List<Alunos> alunos = alunosController.list(); 
        model.addAttribute("alunos", alunos);
        return "informacoes_alunos"; // Retorna o nome do template Thymeleaf (sem a extensão .html)
    }

    @GetMapping("/cadastrar")
    public String formCadastro(Model model) {
        model.addAttribute("aluno", new Alunos());
        return "cadastrar_aluno_projeto";
    }
}
