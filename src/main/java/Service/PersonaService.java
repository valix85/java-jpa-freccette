package Service;
import Entities.Persona;

public interface PersonaService {

    String getAll();
    void insert(Persona g);
    Persona creaGiocatore();
    Persona getById(int id);
    Persona getRandom();

}
