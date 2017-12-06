package Service.Impl;

import Entities.Persona;
import Repository.PersonaRepository;
import Service.PersonaService;

import java.util.Random;

public class PersonaServiceImplRandom implements PersonaService {

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public void insert(Persona p) {

        String[] nomi = {"Mario","Luca","Luigi","Chiara", "Cristina", "Marco", "Paolo", "Agamennone", "Pietro", "Gaia", "Diego", "Valerio", "Gaetano", "Claudio",                            "Ilaria", "Francesco", "Stefano", "Agatino", "Valentina", "Mirko", "Martino", "Alberto", "Linda", "Marika", "Katia", "Riccardo", "Karim", "Lorenzo", "Elisa", "Alessandro", "Domingo", "Danilo", "Daniele", "Davide", "Claudia"};

        String[] cognomi = {"Rossi","Verdi", "Russo", "Ferrari", "Esposito",	"Bianchi", "Romano", "Colombo", "Ricci", "Marino", "Greco", "Bruno","Gallo", "Conti", "De Luca", "Mancini", "Costa", "Giordano",	"Rizzo", "Lombardi", "Moretti", "Barbieri",	"Fontana", "Santoro", "Mariani", "Rinaldi", "Ferrari",	"Galli", "Martini",	"Leone", "Longo", "Gentile", "Martinelli", "Vitale", "Lombardo", "Serra"};

        String[] nickname = {"melead", "uplase", "arnunyav", "siterot", "oraspi", "ednuti", "cassanow", "pendunecl", "ehelorsu", "rendathi", "ilyuap", "susir", "eneadasti", "zotcarige", "celedr", "nouto", "mumpalicr", "yatiomul", "hashin", "tedou", "isitta", "secsalf", "astasout", "ponidrof", "fucofumso", "meatend", "asisisac", "sistiti", "orarta", "rengen", "entarofrasitou", "esashaisinturo", "ureder", "urederejull",
        };

        PersonaRepository pr = new PersonaRepository();
        Random r = new Random();
        //for(int i = 0; i < 100; i++) {
            String nomeTmp = nomi[r.nextInt(nomi.length)];
            String cognomeTmp = cognomi[r.nextInt(cognomi.length)];
            String nicknameTmp = nickname[r.nextInt(nickname.length)] + r.nextInt(100);
            pr.insert(new Persona(nomeTmp,cognomeTmp,nicknameTmp));
        //}

    }

    @Override
    public Persona creaGiocatore() {
        return null;
    }

    @Override
    public Persona getById(int id) {
        return null;
    }

    @Override
    public Persona getRandom() {
        return null;
    }
}
