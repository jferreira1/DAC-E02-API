/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.controllers;

import com.example.dac.models.Artigo;
import com.example.dac.models.Volume;
import com.example.dac.repositories.ArtigoRepository;
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
@RequestMapping(value="/artigo")
public class ArtigoController {
    
    @Autowired
    ArtigoRepository artigoRepository;
    
    @GetMapping("/listar")
    public List<Artigo> listaTodosArtigos() {
        return (List<Artigo>) artigoRepository.findAll();
    }
    
    @GetMapping("/listar/{id}")
    public Artigo listaArtigo(@PathVariable(value="id") Integer id){
        return artigoRepository.findArtigoById(id);
    }
    
    @GetMapping("/listar/volume/{id}")
    public List<Artigo> listaArtigosDeVolume(@PathVariable(value="id") Integer volume_id) {
        return artigoRepository.findArtigoByVolumeId(volume_id);
    }
    
    @PostMapping("/")
    public Artigo criaArtigo(@RequestBody Artigo artigo) {
        return artigoRepository.save(artigo);
    }
    
    @DeleteMapping("/")
    public void deletaArtigo(@RequestBody Artigo artigo){
        artigoRepository.delete(artigo);
    }
    
    @PutMapping("/")
    public Artigo atualizaArtigo(@RequestBody Artigo artigo){
        return artigoRepository.save(artigo);
    }
}
