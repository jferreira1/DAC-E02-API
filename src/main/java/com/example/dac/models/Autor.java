/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable {    
    
    public enum PaisesEnum { BR, PT, US, FR, UK, ES; }
    
    private int id;
    private int ordem;
    private String email;
    private String nome;
    private String nomeMeio;
    private String sobrenome;
    private String afiliacao;
    private String afiliacaoEn;
    private PaisesEnum pais;
    private String orcId;
    private Artigo artigo;
    
    public Autor(){
    }

    public Autor(
        int ordem, 
        String email, 
        String nome, 
        String nomeMeio, 
        String sobrenome, 
        String afiliacao, 
        String afiliacaoEn, 
        PaisesEnum pais, 
        String orcId
    ) {
        this.ordem = ordem;
        this.email = email;
        this.nome = nome;
        this.nomeMeio = nomeMeio;
        this.sobrenome = sobrenome;
        this.afiliacao = afiliacao;
        this.afiliacaoEn = afiliacaoEn;
        this.pais = pais;
        this.orcId = orcId;
    }
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ordem")
    public int getOrdem() {
        return ordem;
    }
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        String regex_email = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex_email);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            this.email = email;
        }
        else {
            throw new Error("Invalid email inserted.");   
        }
    }

    @Column(name = "nome", length = 64)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "nome_meio", length = 64)
    public String getNomeMeio() {
        return nomeMeio;
    }
    public void setNomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
    }

    @Column(name = "sobrenome", length = 64)
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Column(name = "afiliacao", length=256)
    public String getAfiliacao() {
        return afiliacao;
    }
    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    @Column(name = "afiliacao_en", length=256)
    public String getAfiliacaoEn() {
        return afiliacaoEn;
    }
    public void setAfiliacaoEn(String afiliacaoEn) {
        this.afiliacaoEn = afiliacaoEn;
    }

    @Column(name = "pais", length = 2)
    @Enumerated(EnumType.STRING)
    public PaisesEnum getPais() {
        return pais;
    }
    public void setPais(PaisesEnum pais) {
        this.pais = pais;
    }

    @Column(name = "orc_id", length=19)
    public String getOrcId() {
        return orcId;
    }
    public void setOrcId(String orcId) {
        String regex_orcid = "^\\d{4}-\\d{4}-\\d{4}-(\\d{3}X|\\d{4})$";
        Pattern pattern = Pattern.compile(regex_orcid);
        Matcher matcher = pattern.matcher(orcId);
        if(matcher.matches()) {
            this.orcId = orcId;
        }
        else {
            throw new Error("Invalid OrcID inserted.");   
        }
    }   

    @ManyToOne
    @JoinColumn(name="id_artigo")
    @JsonBackReference
    public Artigo getArtigo() {
        return artigo;
    }
    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    @Override
    public String toString() {
        return "modelo.Autor[ id=" + id + " ]";
    }
    
}
