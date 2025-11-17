package br.com.diocesefranca.controller;

import br.com.diocesefranca.repository.IFiel;
import br.com.diocesefranca.model.Fiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private IFiel repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Fiel login) {

        // Busca o fiel pelo email
        Optional<Fiel> fiel = repository.findByEmail(login.getEmail());
        if (fiel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Fiel não encontrado.");
        }

        // Compara senha digitada com o hash
        if (encoder.matches(login.getSenha(), fiel.get().getSenha())) {
            return ResponseEntity.ok("✅ Login realizado com sucesso! Bem-vindo, " + fiel.get().getNome());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Senha incorreta.");
        }
    }
}
