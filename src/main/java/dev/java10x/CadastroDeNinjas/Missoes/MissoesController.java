package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    //POST - mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missaoModel){
        return missoesServices.criarMissoes(missaoModel);
    }

    //PUT - mandar uma requisição para alterar as missoes
    @PutMapping("/alterar/{id}")
    public MissoesModel alteraMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesServices.alteraMissao(id, missaoAtualizada);
    }

    //DELETE - mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesServices.deletaMissao(id);
    }

    //GET - mandar uma requisição para retornar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissao(){
        return missoesServices.listarMissoes();
    }

    //GET - mandar requisicao para listar um missao por vez
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id){
        return missoesServices.listarMissoesPorId(id);
    }
}
