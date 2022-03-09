package com.hefesto.ceos.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hefesto.ceos.model.Usuario;
import com.hefesto.ceos.service.UsuarioService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class UsuarioRestTest {

    @InjectMocks
    private UsuarioRest usuarioRest;
    @MockBean
    private UsuarioService usuarioService;

    public MockMvc mockMvc;
    
    @BeforeAll
    public void setup() throws Exception {
       mockMvc = MockMvcBuilders.standaloneSetup(usuarioRest).build();
    }

    @Test
    public void test() throws Exception{
        when(usuarioService.buscaUsuarioPorId(new Long("1"))).thenReturn(new Usuario());
        mockMvc.perform(get("1/existe"))
        .andExpect(status().isOk());
    }

    @Test
    public void testFalha() throws Exception{
        when(usuarioService.buscaUsuarioPorId(new Long("1"))).thenReturn(new Usuario());
        mockMvc.perform(get("2/existe"))
        .andExpect(status().isNotFound());
    }
}
