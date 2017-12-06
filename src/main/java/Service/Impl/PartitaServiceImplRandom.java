package Service.Impl;

import Entities.Partita;
import Entities.Persona;
import Repository.PartitaRepository;
import Service.PartitaService;
import Utility.RandomData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class PartitaServiceImplRandom implements PartitaService {

    @Override
    public void generaPartita(Persona p) {
        Random r = new Random();
        int punti = r.nextInt(151); // da 0 a 150
        LocalDate data = RandomData.getRandomDate();
        int ore = r.nextInt(24);
        int minuti = r.nextInt(60);
        int secondi = r.nextInt(60);
        LocalTime ora = LocalTime.of(ore,minuti,secondi);
        LocalDateTime data_partita = LocalDateTime.of(data,ora);
        //costruisco la partita
        Partita tmp = new Partita(p,punti,data_partita);
        //salvo la partita
        PartitaRepository pr = new PartitaRepository();
        pr.insert(tmp);
    }


}
