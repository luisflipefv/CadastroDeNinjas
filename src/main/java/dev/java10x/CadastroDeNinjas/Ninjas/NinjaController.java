package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //adicionar ninja
    @PostMapping("/criar")
    public String criaNinja(){
        return "ninja criado";
    }

    //procurar ninja por id
    @GetMapping("/listarID")
    public String mostraTodosOsNinjaPorId(){
        return "Aqui estão os ninjas";
    }

    //mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarTodosNinjas(){
        return ninjaService.listarTodosNinjas();
    }

    //alterar dadoos do ninja
    @PutMapping("/alterarID")
    public String alterarPorId(){
        return "Alterar ninja por ID";
    }

    //deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarPorId(){
        return "Ninja deletado";
    }
}
