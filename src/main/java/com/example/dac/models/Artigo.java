/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "artigo")
public class Artigo implements Serializable {
    
    public enum IdiomasEnum { PT, EN, ES; }

    private int id;
    private int ordem;
    private IdiomasEnum idioma;
    private String titulo;
    private String tituloEn;
    private String resumo;
    private String resumoEn;
    private String keywords;
    private String keywordsEn;
    private int numPaginas;
    private Volume volume;
    private List<Autor> autores = new ArrayList<>();

    
    public Artigo() {
    }

    public Artigo(
        int ordem, 
        IdiomasEnum idioma, 
        String titulo, 
        String tituloEn, 
        String resumo, 
        String resumoEn, 
        String keywords, 
        String keywordsEn, 
        int numPaginas
    ) {
        this.ordem = ordem;
        this.idioma = idioma;
        this.titulo = titulo;
        this.tituloEn = tituloEn;
        this.resumo = resumo;
        this.resumoEn = resumoEn;
        this.keywords = keywords;
        this.keywordsEn = keywordsEn;
        this.numPaginas = numPaginas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="ordem")
    public int getOrdem(){
        return ordem;
    }
    public void setOrdem(int ordem){
        this.ordem = ordem;
    }
    
    @Column(name="idioma", length=2)
    @Enumerated(EnumType.STRING)
    public IdiomasEnum getIdioma(){
        return idioma;
    }
    public void setIdioma(IdiomasEnum idioma){
        this.idioma = idioma;
    }
    
    @Column(name="titulo", length=256)
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    @Column(name="titulo_en", length=256)
    public String getTituloEn(){
        return tituloEn;
    }
    public void setTituloEn(String tituloEn){
        this.tituloEn = tituloEn;
    }
    
    @Column(name="resumo", length=2048)
    public String getResumo(){
        return resumo;
    }
    public void setResumo(String resumo){
        this.resumo = resumo;
    }
    
    @Column(name="resumo_en", length=2048)
    public String getResumoEn(){
        return resumoEn;
    }
    public void setResumoEn(String resumoEn){
        this.resumoEn = resumoEn;
    }

    @Column(name="keywords", length=256)
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Column(name="keywords_en", length=256)
    public String getKeywordsEn() {
        return keywordsEn;
    }
    public void setKeywordsEn(String keywordsEn) {
        this.keywordsEn = keywordsEn;
    }

    @Column(name="num_paginas")
    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @ManyToOne
    @JoinColumn(name="id_volume", nullable=false)
    @JsonBackReference
    public Volume getVolume(){
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }
    
    @OneToMany(mappedBy="artigo")
    @OrderBy("ordem")
    @JsonManagedReference
    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "modelo.Artigo[ id=" + id + " ]";
    }
    
}
