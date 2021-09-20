/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "volume")
public class Volume implements Serializable {

    private int id;
    private String siglaEvento;
    private int numEdicao;
    private String cidadeEvento;
    private String dataInicio;
    private String descPt;
    private String descEn;
    private List<Artigo> artigos = new ArrayList<>();

    public Volume() {
    }

    public Volume(    
        String siglaEvento,
        int numEdicao,
        String cidadeEvento,
        String dataInicio,
        String descPt,
        String descEn
    ) {
        this.siglaEvento = siglaEvento;
        this.numEdicao = numEdicao;
        this.cidadeEvento = cidadeEvento;
        this.dataInicio = dataInicio;
        this.descPt = descPt;
        this.descEn = descEn;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="sigla_evento", length = 32)
    public String getSiglaEvento(){
        return siglaEvento;
    }
    public void setSiglaEvento(String siglaEvento){
        this.siglaEvento = siglaEvento;
    }
    
    @Column(name="num_edicao")
    public int getNumeroEvento(){
        return numEdicao;
    }
    public void setNumeroEvento(int numEdicao){
        this.numEdicao = numEdicao;
    }
    
    @Column(name="cidade_evento", length = 64)
    public String getCidadeEvento(){
        return cidadeEvento;
    }
    public void setCidadeEvento(String cidadeEvento){
        this.cidadeEvento = cidadeEvento;
    }
    
    @Column(name="data_inicio")
    public String getDataInicio(){
        return dataInicio;
    }
    public void setDataInicio(String dataInicio){
            if(dataInicio != null) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateParse = sdf.parse(dataInicio);
                    String dataFormatada = sdf.format(dateParse);
                    this.dataInicio = dataFormatada;
                } catch(Throwable e) {
                    throw new Error("Date format must be \"yyyy-mm-dd\"");
                }
            }
            else {
                this.dataInicio = "0000-01-01";
            }
    }
    
    @Column(name="desc_pt", length = 2048)
    public String getDescPt(){
        return descPt;
    }
    public void setDescPt(String descPt){
        this.descPt = descPt;
    }
    
    @Column(name="desc_en", length = 2048)
    public String getDescEn(){
        return descEn;
    }
    public void setDescEn(String descEn){
        this.descEn = descEn;
    }

    @OneToMany(mappedBy="volume")
    @OrderBy("ordem")
    @JsonManagedReference
    public List<Artigo> getArtigos() {
        return artigos;
    }
    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    @Override
    public String toString() {
        return "modelo.Volume[ id=" + id + " ]";
    }
    
}
