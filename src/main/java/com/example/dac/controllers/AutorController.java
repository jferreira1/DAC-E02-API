/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.controllers;

import com.example.dac.models.Autor;
import com.example.dac.repositories.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jean
 */

@RestController
@RequestMapping(value="/autor")
public class AutorController {
    
    @Autowired
    AutorRepository autorRepository;
    
    @GetMapping("/listar")
    public List<Autor> listaTodosAutores() {
        return (List<Autor>) autorRepository.findAll();
    }
    
    @GetMapping("/listar/{id}")
    public Autor listaAutor(@PathVariable(value="id") Integer id){
        return autorRepository.findAutorById(id);
    }
    
    @GetMapping("/listar/artigo/{id}")
    public List<Autor> listaAutoresDeArtigo(@PathVariable(value="id") Integer artigo_id) {
        return autorRepository.findAutoresByArtigoId(artigo_id);
    }
    
    @PostMapping("/")
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
    
    @DeleteMapping("/")
    public void deletaAutor(@RequestBody Autor autor){
        autorRepository.delete(autor);
    }
    
    @PutMapping("/")
    public Autor atualizaAutor(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }
}
