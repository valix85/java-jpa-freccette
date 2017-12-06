package Utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManager {
    //Solleva la connessione come Singleton con JPA
    private static EntityManagerFactory emf;
    private MyEntityManager() {
    }
    public static EntityManagerFactory getIstance(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("db1");
        }
        return emf;
    }
}
