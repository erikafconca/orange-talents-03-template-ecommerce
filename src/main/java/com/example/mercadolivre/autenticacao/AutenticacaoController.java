package com.example.mercadolivre.autenticacao;

import com.example.mercadolivre.seguranca.TokenResponse;
import com.example.mercadolivre.seguranca.TokenService;
import com.example.mercadolivre.usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private UsuarioRepository repository;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    public AutenticacaoController(UsuarioRepository repository,
                                  AuthenticationManager authenticationManager,
                                  TokenService tokenService) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginRequest loginRequest){

        UsernamePasswordAuthenticationToken dadosLogin;

        dadosLogin = new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getSenha());
        try {
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);

            String token = tokenService.gerarToken(authenticate);

            return ResponseEntity.ok(new TokenResponse(token, "Beare"));

        }catch (AuthenticationException ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
