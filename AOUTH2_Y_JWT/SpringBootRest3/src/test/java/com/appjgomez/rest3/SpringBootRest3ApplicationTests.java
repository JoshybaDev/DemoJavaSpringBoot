package com.appjgomez.rest3;

import com.appjgomez.rest3.security.EncryptDecrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootRest3ApplicationTests {

    @Autowired
    private MockMvc mvc;

    private String subject;
    private Instant expirationDate;
    private List<GrantedAuthority> authorities;
    private EncryptDecrypt encryptionService;

    @BeforeEach
    public void setUp() throws Exception {

        String subject = "jgomez";
        Instant expirationDate = Instant.now().plusSeconds(3600);
        authorities = Arrays.asList(
                new SimpleGrantedAuthority("SCOPE_read"),
                new SimpleGrantedAuthority("SCOPE_write")
        );
        encryptionService = new EncryptDecrypt();
    }

    @Test
    public void encriptarCadena() throws Exception {
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
	void leerTodosLosUsuariosTokenValido() throws Exception {
		this.mvc.perform(get("/api/v1/users").with(
						jwt()
								.jwt(jwt -> jwt.claim(StandardClaimNames.SUB, subject).expiresAt(expirationDate))
								.authorities(authorities)
				))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(6));
	}           
}

/*


package example.cashcard;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class CashCardApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnACashCardWhenDataIsSaved() throws Exception {
        this.mvc.perform(get("/cashcards/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(99))
                .andExpect(jsonPath("$.owner").value("sarah1"));
    }

    @Test
    @DirtiesContext
    void shouldCreateANewCashCard() throws Exception {
        String location = this.mvc.perform(post("/cashcards")
                .with(csrf())
                        .contentType("application/json")
                        .content("""
                        {
                            "amount" : 250.00,
                            "owner"  : "sarah1"
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andReturn().getResponse().getHeader("Location");

        this.mvc.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(250.00))
                .andExpect(jsonPath("$.owner").value("sarah1"));
    }

    @Test
    void shouldReturnAllCashCardsWhenListIsRequested() throws Exception {
        this.mvc.perform(get("/cashcards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$..owner").value(hasItem("sarah1")))
                .andExpect(jsonPath("$..owner").value(hasItem("esuez5")));
    }
}
 */
