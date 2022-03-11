package com.hefesto.ceos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hefesto.ceos.enums.Classe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class CeosApplicationTests {

	@Test
	void contextLoads() {
        assertEquals(Classe.ADMINISTRADOR.ordinal(), 0);
        assertEquals(Classe.USUARIO.ordinal(), 1);
		assertEquals(1 , 0);
	}

}
