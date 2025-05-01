package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesServices {
    private MissoesRepository missoesRpository;

    public MissoesServices(MissoesRepository missoesRpository) {
        this.missoesRpository = missoesRpository;
    }

    //Criar missoes
    public MissoesModel criarMissoes(MissoesModel missao){
        return missoesRpository.save(missao);
    }

    //Deletar missoes por id
    public void deletaMissao(Long id){
        missoesRpository.deleteById(id);
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRpository.findAll();
    }

    //Listar missoes por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel>missaoPorId = missoesRpository.findById(id);
        return missaoPorId.orElse(null);
    }

    //Alterar missoes
    public MissoesModel alteraMissao (Long id, MissoesModel missaoAtualizada){
        if(missoesRpository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRpository.save(missaoAtualizada);
        }
        else {
            return null;
        }
    }
}
