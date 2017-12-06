package Entities;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id_persona;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String nickname;

    @OneToMany( mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //name colonna della tabella di questa entità
    //ReferencedColumnName colonna riferita nella tabella remota
    private List<Partita> partite;

    public Persona() {
        this.partite=new ArrayList<>();
    }

    public Persona(int id, String nome, String cognome, String nickname) {
        this.id_persona =id;
        this.nome = nome;
        this.cognome = cognome;
        this.nickname = nickname;
    }

    public Persona(String nome, String cognome, String nickname) {
        this.nome = nome;
        this.cognome = cognome;
        this.nickname = nickname;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id) {
        this.id_persona = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Persona" +
                "\nid: " + id_persona +
                "\nNome: " + nome +
                "\nCognome: " + cognome +
                "\nNickname: " + nickname;
    }
}
