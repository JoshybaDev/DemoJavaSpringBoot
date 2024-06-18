/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers;

import com.appjgomez.rest3.entities.Pokemon;
import com.appjgomez.rest3.entities.PokemonResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author JGomez
 */
@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

    @GetMapping("/{name}")
    public ResponseEntity<?> findData(@PathVariable String name) {
        if (name == null) {
            return ResponseEntity.badRequest().build();
        }
        if (name.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        //System.out.println("========================> GET POINT ==> /api/v1/pokemon/" + name);
        System.out.println("========================> " + url);
        RestTemplate restTemplate = new RestTemplate();
        Object Data = restTemplate.getForObject(url, Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        Pokemon pokemon = mapper.convertValue(Data, Pokemon.class);
        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setId(pokemon.getId());
        pokemonResponse.setIs_default(pokemon.getIs_default());
        pokemonResponse.setLocation_area_encounters(pokemon.getLocation_area_encounters());
        pokemonResponse.setMoves(pokemon.getMoves());
        pokemonResponse.setOrder(pokemon.getOrder());
        pokemonResponse.setPast_abilities(pokemon.getPast_abilities());
        pokemonResponse.setPast_types(pokemon.getPast_types());
        pokemonResponse.setSpecies(pokemon.getSpecies());
        pokemonResponse.setSprites(pokemon.getSprites());
        pokemonResponse.setStats(pokemon.getStats());
        pokemonResponse.setTypes(pokemon.getTypes());
        pokemonResponse.setWeight(pokemon.getWeight());
        return ResponseEntity.ok(pokemonResponse);
    }
}
