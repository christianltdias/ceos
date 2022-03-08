package com.hefesto.ceos.rest;

import javax.validation.Valid;

import com.hefesto.ceos.dto.TokenDTO;
import com.hefesto.ceos.form.LoginForm;
import com.hefesto.ceos.security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController()
@RequestMapping("/auth")
public class AutenticacaoRest {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "Autentica o usuário para geração do token")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Usuário autenticado", response = TokenDTO.class),
        @ApiResponse(code = 403, message = "Usuário não autorizado")
    })
    @PostMapping("authenticate")
    public ResponseEntity<?> autenticar(@Valid @RequestBody LoginForm loginForm){
        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        }
        catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
