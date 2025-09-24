package dev.Gendesson.CadastroDeNinjas.Ninjas;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();

    }


}
