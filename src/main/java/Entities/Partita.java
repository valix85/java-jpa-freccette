package Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Partita {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int punteggio;
    @Column
    private LocalDateTime data_partita;

    //Relazioni
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    @JoinColumn(name="id_persona", referencedColumnName = "id" )
    //name = nome della colonna che è chiave esterna di questa TABELLA
    //referencedColumnName = nome della colonna della TEABELLA remota che rappresenta la chiave
    private Persona persona;

    public Partita(){}

    public Partita(int id, Persona persona, int punteggio, LocalDateTime data_partita) {
        this.id = id;
        this.persona=persona;
        this.punteggio = punteggio;
        this.data_partita = data_partita;
    }

    public Partita(int punteggio, LocalDateTime data_partita) {
        this.id = id;
        this.punteggio = punteggio;
        this.data_partita = data_partita;
    }

    public Partita(Persona persona, int punteggio, LocalDateTime data_partita) {
        this.persona = persona;
        this.punteggio = punteggio;
        this.data_partita = data_partita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setFk_id_persona(int fk_id_persona) {
        this.persona = persona;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public LocalDateTime getData_partita() {
        return data_partita;
    }

    public void setData_partita(LocalDateTime data_partita) {
        this.data_partita = data_partita;
    }

    @Override
    public String toString() {
        return "Partita{" +
                "id=" + id +
                ", fk_id_persona=" + persona +
                ", punteggio=" + punteggio +
                ", data_partita=" + data_partita +
                '}';
    }
}
