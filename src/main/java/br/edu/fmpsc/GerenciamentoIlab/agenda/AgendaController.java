package br.edu.fmpsc.GerenciamentoIlab.agenda;

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
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private IAgendaRepository agendaRepository;

    @PostMapping("")
    public ResponseEntity createAgenda(@RequestBody Agenda agenda){
        var projetoCreated = this.agendaRepository.save(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoCreated);
    }

    @GetMapping("")
    public List<Agenda> list(){
        return agendaRepository.findAll();
    }
}
