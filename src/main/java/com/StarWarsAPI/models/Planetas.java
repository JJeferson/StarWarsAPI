package com.StarWarsAPI.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planetas")
public class Planetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long   id_planeta;
    private String nome;
    private String clima;
    private String terreno;
    private int    qtdefilmes;

    public int getQtdefilmes() {
        return qtdefilmes;
    }

    public void setQtdefilmes(int qtdefilmes) {
        this.qtdefilmes = qtdefilmes;
    }

    public long getId_planeta() {
        return id_planeta;
    }

    public void setId_planeta(long id_planeta) {
        this.id_planeta = id_planeta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }
}
