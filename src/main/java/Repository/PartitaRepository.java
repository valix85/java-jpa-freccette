package Repository;

import Entities.Partita;
import Utility.Conn;

public class PartitaRepository {
    public void insert(Partita tmp) {
/*
        String sql = "INSERT INTO partita (id_persona, punteggio, data_partita) VALUES " +
                "('"+tmp.getPersona().getId_persona()+"','"+tmp.getPunteggio()+"','"+tmp.getData_partita()+"');";
        System.out.println(sql);
*/
/*
        Connection conn = Conn.getConn();
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
/*
        //bene ma non benissimo
        EntityManager em = Conn.getEMJPA();
        em.getTransaction().begin();
        em.persist(tmp);
        em.getTransaction().commit();
        em.close();
*/
        Conn.insert(tmp);


    }
}
