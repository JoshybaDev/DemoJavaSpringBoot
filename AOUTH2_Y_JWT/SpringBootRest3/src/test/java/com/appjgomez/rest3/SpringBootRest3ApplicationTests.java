package com.appjgomez.rest3;

import com.appjgomez.rest3.security.EncryptDecrypt;
import com.appjgomez.rest3.utils.LogColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@WithMockUser
class SpringBootRest3ApplicationTests {

    @Autowired
    private MockMvc mvc;

    private String subject;
    private Instant expirationDate;
    private List<GrantedAuthority> authorities;
    private EncryptDecrypt encryptionService;

    @BeforeEach
    void setUp() throws Exception {

        String subject = "jgomez";
        Instant expirationDate = Instant.now().plusSeconds(3600);
        authorities = Arrays.asList(
                new SimpleGrantedAuthority("SCOPE_read"),
                new SimpleGrantedAuthority("SCOPE_write")
        );
        encryptionService = new EncryptDecrypt();
    }

    @Test
    void encriptarCadena() throws Exception {
        this.mvc.perform(post("/api/v1/security/encrypt")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                            "textclear" : "JGomez"
                        }
                        """)
        )
                .andExpect(status().isOk());
    }

    @Test
    void desencriptarCadena() throws Exception {
        this.mvc.perform(post("/api/v1/security/decrypt")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                            "textencrypt" : "+41q7Y0nuMHoKZXf7RTHraUBDpg71rfxgmmE3Y5fF/E="
                        }
                        """)
        )
                .andExpect(status().isOk());
    }

    @Test
    void leerTodasLasTiendasTokenValido() throws Exception {
        this.mvc.perform(get("/api/v1/makers").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    @Test
    void leerTodosLosProductosTokenValido() throws Exception {
        this.mvc.perform(get("/api/v1/products").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(8));
    }

    @Test
    void encontrarPokemonConTokenValido() throws Exception {
        this.mvc.perform(get("/api/v1/pokemon/ditto").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk());
    }

    @Test
    void encontrarPokemonSinToken() throws Exception {
        this.mvc.perform(get("/api/v1/pokemon/ditto"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void leerTodosLosUsuariosTokenValido() throws Exception {
        this.mvc.perform(get("/api/v1/users").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6))
                .andExpect(jsonPath("$..firstName").value(hasItem("Joshua")))
                .andExpect(jsonPath("$..firstName").value(hasItem("Raul")));
    }

    @Test
    void leerUnUsuariosTokenValido() throws Exception {
        this.mvc.perform(get("/api/v1/users/1006").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$..id").value(1006));
    }

    @Test
    void crearyEliminarUnProductoConTokenValido() throws Exception {
        LogColor.i("TEST", "========================================================================================");
        LogColor.i("TEST", "========================> " + "crearyEliminarUnProductoConTokenValido");
        LogColor.i("TEST", "========================> " + "Crear");    
        //Creamos un producto
        this.mvc.perform(post("/api/v1/products")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                        	"name":"Monitor LCD 27",
                        	"price":"5636.25",
                        	"maker":{"id":100}
                        }
                        """)
        )
                .andExpect(status().isCreated());
        //Elimanos producto
        LogColor.i("TEST", "========================> " + "Eliminar");
        this.mvc.perform(delete("/api/v1/products/1").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk());
    }

    @Test
    void crearyEliminarUnaTiendaConTokenValido() throws Exception {
        LogColor.i("TEST", "========================================================================================");
        LogColor.i("TEST", "========================> " + "crearyEliminarUnaTiendaConTokenValido");
        LogColor.i("TEST", "========================> " + "Crear");
        //Creamos una Tienda
        this.mvc.perform(post("/api/v1/makers")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                        	"name":"LG"
                        }
                        """)
        )
                .andExpect(status().isCreated());
        //Elimanos Tienda
        LogColor.i("TEST", "========================> " + "Eliminar");
        this.mvc.perform(delete("/api/v1/makers/1").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities)
        ))
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    void guardarUnUsuarioTokenValido() throws Exception {
        String location = this.mvc.perform(post("/api/v1/users")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                          "firstName": "Nombre",
                          "lastName": "Apellidos",
                          "email": "correo@dominio.com"	
                        }
                        """)
        )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andReturn().getResponse().getHeader("Location");

        this.mvc.perform(get(location)
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Nombre"))
                .andExpect(jsonPath("$.email").value("correo@dominio.com"));
    }

    @Test
    void actualizarUnUsuarioTokenValido() throws Exception {
        this.mvc.perform(put("/api/v1/users/1003")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
                .contentType("application/json")
                .content("""
                        {
                          "firstName": "Alicia Pais",
                          "lastName": "Maravillas",
                          "email": "aliciapm@javademo.com"	                         
                        }
                        """)
        )
                .andExpect(status().isOk());

        this.mvc.perform(get("/api/v1/users/1003")
                .with(
                        jwt()
                                .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                                .authorities(authorities)
                )
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alicia Pais"))
                .andExpect(jsonPath("$.email").value("aliciapm@javademo.com"));
    }

    @Test
    void leerTodosLosUsuariosRolIncorrecto() throws Exception {
        List<GrantedAuthority> authorities2;
        authorities2 = Arrays.asList(
                new SimpleGrantedAuthority("ADMIN")
        ); // Múltiples roles

        this.mvc.perform(get("/api/v1/users").with(
                jwt()
                        .jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
                        .authorities(authorities2)
        ))
                .andExpect(status().isForbidden());
    }

}
