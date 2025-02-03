package com.ids.ProgettoIDS.Model;


import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "Contest")
public class Contest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String nome;
    private String descrizione;
    private Date dataInizio;
    private Date dataFine;
    private String tipo;
    private String regole;
    @ManyToMany
    private List<Contenuto> contenuti;
    @ManyToOne
    private Contenuto contenutoVincitore;
    @ManyToOne
    private Comune comune;
    @ManyToOne
    private Utente creatore;

    private  boolean aperto;

    public Contest(String nome, String descrizione, Date dataInizio, Date dataFine, List<Integer> contenuti,
                   String tipo, String regole, Integer comune, Integer creatore) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.contenuti = new ArrayList<>();
        this.tipo = tipo;
        this.regole = regole;
        this.comune = new Comune();
        this.comune.setID(comune);
        this.creatore = new Utente();
        this.creatore.setID(creatore);
        this.aperto = true;
    }

    public Contest() {
    }

    public Utente getCreatore() {
        return creatore;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public Integer getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setCreatore(Utente creatore) {
        this.creatore = creatore;
    }

    public void iscrizione(Contenuto contenuto) {
        for (Contenuto c : contenuti) {
            if (c.getID().equals(contenuto.getID())) {
                throw new IllegalStateException("Contenuto già iscritto");
            }
        }

        this.contenuti.add(contenuto);
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Set<Integer> chiusuraContest(Integer idVincitore) {
        if (!this.aperto) {
            throw new IllegalStateException("Contest chiuso");
        }

        this.aperto = false;
        this.contenutoVincitore = this.contenuti.stream()
                .filter(c -> c.getID().equals(idVincitore))
                .findFirst().orElse(null);

        if (this.contenutoVincitore == null) {
            this.aperto = true;
            throw new IllegalStateException("Contest chiuso");
        }

        Set<Integer> perdente = new HashSet<>();
        for (Contenuto contenuto : this.contenuti) {
            if (!contenuto.getCreatore().getID().equals(idVincitore)) {
                perdente.add(contenuto.getCreatore().getID());
            }
        }

        return perdente;
    }

    public TipoContenuto getTipoContenuto(){
        return TipoContenuto.CONTEST;
    }
}
