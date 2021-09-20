/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.controllers;

import com.example.dac.models.Volume;
import com.example.dac.repositories.VolumeRepository;
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
@RequestMapping(value="/volume")
public class VolumeController {
    
    @Autowired
    VolumeRepository volumeRepository;
    
    @GetMapping("/listar")
    public List<Volume> listaTodosVolumes() {
        return (List<Volume>) volumeRepository.findAll();
    }
    
    @GetMapping("/listar/{id}")
    public Volume listaVolume(@PathVariable(value="id") Integer id){
        return volumeRepository.findVolumeById(id);
    }
    
    @PostMapping("/")
    public Volume criaVolume(@RequestBody Volume volume) {
        return volumeRepository.save(volume);
    }
    
    @DeleteMapping("/")
    public void deletaVolume(@RequestBody Volume volume){
        volumeRepository.delete(volume);
    }
    
    @PutMapping("/")
    public Volume atualizaVolume(@RequestBody Volume volume){
        return volumeRepository.save(volume);
    }
}
