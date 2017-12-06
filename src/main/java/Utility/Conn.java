package Utility;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

public class Conn {
    /*
    public static Connection getConn(){
        ConnessioneDB connessione = ConnessioneDB.getInstance();
        Connection conn = connessione.getConnessione();
        return conn;
    }
    */

    //creo l'entity manager a partire dla profilo di connessione presente nel file di configrazione in META-INF/persistence.xml
    private static EntityManagerFactory emf;

    public static void openConnection(){
        System.out.println("Apertura connessione in corso...");
        emf = Persistence.createEntityManagerFactory("db1");
    }

    public static EntityManager getEMJPA(){
        //creo il manager delle CRUD operation a partire dalla connesione
         return emf.createEntityManager();
    }

    public static void closeConnection(){
        System.out.println("Chiusura connessione in corso...");
        emf.close();
    }

    /* metodi di utilità */
    //insert
    public static void insert(Object item){
        EntityManager em = Conn.getEMJPA();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }
    //merge
    public static void merge(Object item){
        EntityManager em = Conn.getEMJPA();
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
        em.close();
    }



}
