package com.enquete.apirest.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "votacao")
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_votacao")
    private long id;

    @Column(name="data_inicio")
    private Date dataInicio;

    @Column(name="validade")
    private Date validade;

    @OneToOne
    @JoinColumn(name = "pauta")
    private Pauta pauta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

}