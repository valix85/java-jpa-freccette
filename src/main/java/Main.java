import Entities.Partita;
import Entities.Persona;
import Service.ClassificaService;
import Service.FileSaver;
import Service.Impl.*;
import Service.PartitaService;
import Service.PersonaService;
import Utility.Conn;
import Utility.ConnessioneDB;
import Utility.Input;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    //public static Connection conn;
    public static void main(String[] args) {
        /*
        ConnessioneDB connessione = ConnessioneDB.getInstance();
        connessione.setDriver("com.mysql.jdbc.Driver");
        connessione.setUrl("jdbc:mysql://localhost:3306/freccette");
        connessione.setUser("root");
        connessione.setPassword("root");
        */
        Conn.openConnection();
        System.out.println("Benevenuto nel gioco delle freccette!");
        menu();
        Conn.closeConnection();
    }//END MAIN









    //creo un menu da poter utilizzare
    public static void menu(){

        Scanner s = new Scanner(System.in);
        String mex = "Premi: \n1 per aggiungere un giocatore " +
                                "\n2 per selezionare il giocatore tramite id \n3 per giocare la partita " +
                                "\n4 per mostrare la classifica \n9 per uscire \n99 per caricare i dati di prova";

        Persona p = null;
        while(true) {
            System.out.println(mex);
            String input = s.nextLine();

            if (input.equalsIgnoreCase("1")) {
                System.out.println("\n::: INSERIMENTO UTENTE ::: \n");
                metodoInserimentoGiocatore();

            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("Inserisci l'ID del giocatore desiderato: ");
                p = metodoEstrazioneGiocatoreDaId();

            } else if (input.equalsIgnoreCase("3")) {
                if (p != null) {
                    System.out.println("Gioca partita del giocatore " + p.getId_persona() + " ("+p.getNome()+" "+p.getCognome()+")");
                    creaPartitaPerPersona(p);
                }else{
                    System.out.println("Gioca partita di un giocatore randomico");
                    creaPartitaPerPersona();
                }

            } else if (input.equalsIgnoreCase("4")) {
                System.out.println("mostra classifica");
                stampaClassifica();

            } else if (input.equalsIgnoreCase("9")) {
                System.out.println("Bye bye!");
                break;
                //System.exit(-1);

            } else if (input.equalsIgnoreCase("99")) {
                System.out.println("dati di prova: ");
                generaDatiDiProva();

            } else {
                System.out.println("comando non riconosciuto, riprovare!");
            }
        }//end while
    }//end main



    /*
    * -----------------------------------------------------------------------------
    * */

    private static void metodoInserimentoGiocatore(){
        PersonaService gs = new PersonaServiceImpl();
        Persona nuovoPersona = gs.creaGiocatore();
        //System.out.println(tmp);
        gs.insert(nuovoPersona);
    }

    private static Persona metodoEstrazioneGiocatoreDaId(){
        //System.out.println("Inserisci l'ID del giocatore desiderato");
        int idPersona = Input.leggiIntero();
        PersonaService ps = new PersonaServiceImpl();
        Persona tmp = ps.getById(idPersona);

        if (tmp!=null){
            System.out.println(tmp);
            return tmp;
        }else{
            System.out.println("Nessuna persona con l'ID richiesto");
        }
        return null;
    }




    private static void creaPartitaPerPersona(Persona p) {
        PartitaService ps = new PartitaServiceImplRandom();
        ps.generaPartita(p);
    }

    private static void creaPartitaPerPersona(){
        PersonaService ps = new PersonaServiceImpl();
        Persona prandom = ps.getRandom();
        System.out.println("Giocata per: " +  + prandom.getId_persona() + " ("+prandom.getNome()+" "+prandom.getCognome()+")" );
        creaPartitaPerPersona(prandom);
    }



    private static void generaDatiDiProva() {
        PersonaService ps = new PersonaServiceImplRandom();
        for (int i=0; i<5;i++){
            ps.insert(new Persona());
        }
        for (int i=0; i<1000;i++){
            creaPartitaPerPersona();
        }
    }

    private static void stampaClassifica() {
        ClassificaService cs = new ClassificaServiceImpl();
        List<Partita> tmp = cs.getClassifica();
        for(int i=0; i<tmp.size();i++){
            System.out.print(i+1+" - ");
            System.out.print(tmp.get(i).getPersona().getNome()+" ");
            System.out.print(tmp.get(i).getPersona().getCognome()+" ");
            System.out.println(tmp.get(i).getPunteggio());
        }
        System.out.println("");
        aggiornaFile(tmp);
    }

    private static void aggiornaFile(List<Partita> tmp) {
        FileSaver fshtml = new FileSaverImplHTML();
        String fhtml = fshtml.salvaClassifica(tmp);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(fhtml));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }



    }


}//END CLASS
