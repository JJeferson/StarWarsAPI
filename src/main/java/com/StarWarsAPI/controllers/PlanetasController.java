package com.StarWarsAPI.controllers;


import com.StarWarsAPI.WebService.cabecalhoAPI;
import com.StarWarsAPI.WebService.dadosAPI;
import com.StarWarsAPI.models.Planetas;
import com.StarWarsAPI.repository.PlanetasRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.transaction.Transactional;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
@RequestMapping(value="/starwars")
public class PlanetasController {

    @Autowired
    PlanetasRepository planetasRepository;

    @DeleteMapping("/estreladamorte")
    public ResponseEntity<Planetas>  estrelaDaMorte(@RequestBody Planetas planetas){
        planetasRepository.delete(planetas);
        return ResponseEntity.ok(planetas);
    }


    @GetMapping("/planetapornome/{nome}")
    public ResponseEntity<List<Planetas>> PlanetasPorNome(@PathVariable(value="nome") String nome){
        List<Planetas> PlanetasPorNome = planetasRepository.findByNome(nome);
        return ResponseEntity.ok(PlanetasPorNome);
    }


    @GetMapping("/planetas/{id}")
    public ResponseEntity<Planetas> planetasPorID(@PathVariable(value="id") long id){
        Planetas planeta = planetasRepository.findById(id);
        return ResponseEntity.ok(planeta);

    }


    @GetMapping("/planetas")
    public ResponseEntity<List<Planetas>> planetasTodos(){
        return ResponseEntity.ok(planetasRepository.findAll());
    }


    @Transactional
    @CacheEvict(value = "/planetas", allEntries = true)
    @PostMapping("/planetas")
    public ResponseEntity<Planetas> planetasGrava (@RequestBody Planetas planetas){
        if(planetas.getNome() == "" || planetas.getNome() == null) {
            return ResponseEntity.badRequest().eTag("Erro: Nome precisa ser informado!").build();
        }
        if(planetas.getClima() == "" || planetas.getClima() == null) {
            return ResponseEntity.badRequest().eTag("Erro: Clima precisa ser informado!").build();
        }
        if(planetas.getTerreno() == "" || planetas.getTerreno() == null) {
            return ResponseEntity.badRequest().eTag("Erro: Terreno precisa ser informado!").build();
        }

        RestTemplate restTemplate = new RestTemplate();
        cabecalhoAPI recebeCabecalho = restTemplate.getForObject("https://swapi.dev/api/planets/", cabecalhoAPI.class);
        int contador = 1;
        while (contador < recebeCabecalho.getCount()) {
        dadosAPI recebeDadosAPI = restTemplate.getForObject("https://swapi.dev/api/planets/"+String.valueOf(contador)+"/", dadosAPI.class);
             if (recebeDadosAPI.getName().equals(planetas.getNome()) && recebeDadosAPI.getResidents() != null){
             int numeroFilmes = recebeDadosAPI.getResidents().size();
             planetas.setQtdefilmes(numeroFilmes);
             return ResponseEntity.ok(planetasRepository.save(planetas));
         }
         contador = contador+1;
        }

        planetas.setQtdefilmes(0);
        return ResponseEntity.ok(planetasRepository.save(planetas));

    }


}
