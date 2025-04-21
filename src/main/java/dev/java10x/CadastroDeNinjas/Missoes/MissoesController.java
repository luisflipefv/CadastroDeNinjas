package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //POST - mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return null;
    }

    //PUT - mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return null;
    }

    //DELETE - mandar uma requisição para alterar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return null;
    }

    //GET - mandar uma requisição para retornar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return null;
    }
}
