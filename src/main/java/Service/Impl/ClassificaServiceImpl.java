package Service.Impl;

import Entities.Partita;
import Repository.ClassificaRepository;
import Service.ClassificaService;

import java.util.List;

public class ClassificaServiceImpl implements ClassificaService{

    @Override
    public List getClassifica() {
        ClassificaRepository cr = new ClassificaRepository();
        List<Partita> classifica = cr.getClassificaMese();
        return classifica;
    }
}
