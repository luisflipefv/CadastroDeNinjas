package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarTodosNinjas(){
        return ninjaRepository.findAll();
    }

    //Lista ninja pelo ID
    public NinjaModel listarNinjaId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel model){
        return ninjaRepository.save(model);
    }

    //Deletar NInja
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaModel atualizaNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        else {
            return null;
        }
    }

}
