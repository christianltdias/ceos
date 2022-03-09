package com.hefesto.ceos.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hefesto.ceos.adapters.UsuarioAdapter;
import com.hefesto.ceos.form.UsuarioForm;
import com.hefesto.ceos.model.ClasseUsuario;
import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.ClasseUsuarioService;
import com.hefesto.ceos.service.UsuarioService;
import com.hefesto.ceos.utils.UsuarioUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClasseUsuarioService classeUsuarioService;

    @GetMapping
    private String retornaMinhaInfo(){
        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioAdapter()).create();
        Usuario logado = UsuarioUtil.getInstance().getUsuarioDetails().getUsuario();
        return gson.toJson(logado);
    }

    @GetMapping("/lista")
    private String bucaTodos(){
        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioAdapter()).create();
        List<Usuario> usuarios = usuarioService.getTodos();
        return gson.toJson(usuarios);
    }

    @GetMapping("/{idUsuario}")
    private String buscaUsuario(@PathVariable Long idUsuario){
        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioAdapter()).create();
        Usuario usuario = usuarioService.buscaUsuarioPorId(idUsuario);
        return gson.toJson(usuario);
    }

    @PostMapping("/cadastrar")
    private ResponseEntity<String> cadastrar(@Valid @RequestBody UsuarioForm usuarioForm, 
        UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioForm.toUsuario();
        ClasseUsuario classeUsuario = classeUsuarioService.findByNome("Aluno");
        usuario.setClasseUsuario(classeUsuario);
        usuarioService.save(usuario);
        
        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioAdapter()).create();
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        
        return  ResponseEntity.created(uri).body(gson.toJson(usuario));
    }

    @GetMapping("/{idUsuario}/existe")
    private ResponseEntity verificaSeUsuarioExiste(@PathVariable Long idUsuario){
        Usuario usuario = usuarioService.buscaUsuarioPorId(idUsuario);
        if(usuario != null)
         return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
