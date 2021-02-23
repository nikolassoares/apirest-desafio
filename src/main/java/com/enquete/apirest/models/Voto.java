package com.enquete.apirest.models;


import javax.persistence.*;

@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_voto")
    private long id;

    @Column(name = "opcao")
    private boolean opcao;

    @OneToOne
    @JoinColumn(name = "associado")
    private Associado associado;

    @ManyToOne
    @JoinColumn(name = "votacao")
    private Votacao votacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOpcao() {
        return opcao;
    }

    public void setOpcao(boolean opcao) {
        this.opcao = opcao;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
}
