package Repository;

import Entities.Partita;
import Entities.Persona;
import Service.Impl.PersonaServiceImpl;
import Service.PersonaService;
import Utility.Conn;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassificaRepository {

    public List<Partita> getClassificaMese(){

        String sql = "select * \n" +
                "from partita \n" +
                "join persona as p \n" +
                "on partita.id_persona=p.id \n" +
                "WHERE MONTH(data_partita) = MONTH(CURDATE()) AND YEAR(data_partita) =YEAR(CURDATE())\n" +
                "ORDER BY punteggio desc " +
                "Limit 0,10;";
        System.out.println(sql);

        EntityManager em = Conn.getEMJPA();
        Query record = em.createNativeQuery(sql,Partita.class);
        List<Partita> ris = (List<Partita>) record.getResultList();
        em.close();

        /*
        Connection conn = Conn.getConn();
        try{
            PersonaService ps = new PersonaServiceImpl();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Partita> tmp = new ArrayList<>();
            while(rs.next()){
                Partita ptmp = new Partita(
                        rs.getInt(1),
                        //ps.getById(rs.getInt(2)),
                        new Persona(
                                rs.getInt(2),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                        ),
                        rs.getInt(3),
                        rs.getTimestamp(4).toLocalDateTime()
                );
                tmp.add(ptmp);
            }
            rs.close();
            st.close();
            return tmp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        return ris;
    }



}
