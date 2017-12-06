package Repository;

import Entities.Persona;
import Utility.Conn;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonaRepository {
    public void insert(Persona p) {
        /*
        String sql = "INSERT INTO persona (nome, cognome, nickname) VALUES "
                + " (`'" + p.getNome() + "`,`" + p.getCognome() + "`,`" + p.getNickname() + "`) "
                + ";";
        */
        /*
        Connection conn = Conn.getConn();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            System.out.println("Operazione avvenuta con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        /*
        //bene ma non benissimo
        EntityManager em = Conn.getEMJPA();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        */

        Conn.insert(p);

    }

    public Persona getById(int id) {
        /*
        String sql = "SELECT * FROM persona WHERE id='"+id+"';";
        System.out.println(sql);
        Connection conn = Conn.getConn();
        Persona tmp = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tmp = new Persona(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            rs.close();
            st.close();
            System.out.println("Operazione avvenuta con successo.");
            if (tmp!=null){return tmp;}
        } catch (SQLException e) {
            System.out.println("Errore nel recupero dell'id");
            e.printStackTrace();
        }
        */


        //jpa3
        EntityManager em = Conn.getEMJPA();
        TypedQuery<Persona> record = em.createQuery("SELECT e FROM Persona AS e WHERE id_persona=:param1",Persona.class);
        record.setParameter("param1", id);
        Persona ris = record.getSingleResult();
        em.close();
        return ris;

    }


    public Persona getRandomRecord(){
        String sql = "SELECT * FROM persona order by RAND() LIMIT 0,1;";
        //System.out.println(sql);
        EntityManager em = Conn.getEMJPA();
        Query record = em.createNativeQuery(sql, Persona.class);
        Persona r = (Persona) record.getSingleResult();
        /*
        //versione per risultati multipli
        List<Persona> ris = (List<Persona>) record.getResultList();
        Persona p = null;
        if (ris.size()!=0){
            p = ris.get(0);
        }*/
        em.close();
        /*
        Connection conn = Conn.getConn();
        Persona tmp = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tmp = new Persona(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            rs.close();
            st.close();
            System.out.println("Operazione avvenuta con successo.");
            if (tmp!=null){return tmp;}
        } catch (SQLException e) {
            System.out.println("Errore nel recupero della persona casuale");
            e.printStackTrace();
        }
        */
        return r;
    }



}