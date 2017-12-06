package Service.Impl;

import Entities.Persona;
import Repository.PersonaRepository;
import Service.PersonaService;
import Utility.Input;

public class PersonaServiceImpl implements PersonaService {

    public String inserisciGiocatore(){
    return null;
    };

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public void insert(Persona g) {
        PersonaRepository pp = new PersonaRepository();
        pp.insert(g);
    }

    @Override
    public Persona creaGiocatore() {
        String nome, cognome, nickname;
        System.out.println("Inserisci un nome");
        nome= Input.leggiStringa();
        System.out.println("Inserisci un cognome");
        cognome= Input.leggiStringa();
        do{
            System.out.println("Inserisci un nickname (almeno 3 caratteri)");
            nickname=Input.leggiStringa();
        }while(nickname.length()<=2);
        return new Persona(nome,cognome,nickname);
    }

    @Override
    public Persona getById(int id) {
        PersonaRepository pr = new PersonaRepository();
        return pr.getById(id);
    }

    @Override
    public Persona getRandom() {
        PersonaRepository pr = new PersonaRepository();
        return pr.getRandomRecord();
    }
}
