package br.edu.fmpsc.GerenciamentoIlab.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("")
    public ResponseEntity create(@RequestBody User user)
    {
        var userEmail = this.userRepository.findByEmail(user.getEmail());

        if(userEmail != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user.getNome() + "já existe.");
        }

        String passHash = BCrypt.withDefaults().hashToString(12, user.getSenha().toCharArray());

        user.setSenha(passHash);

        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
