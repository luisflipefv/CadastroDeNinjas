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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaModel){
        return ninjaService.criarNinja(ninjaModel);
    }

    //procurar ninja por id
    @GetMapping("/listar/{id}")
    public NinjaDTO mostraTodosOsNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);
    }

    //mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarTodosNinjas(){
        return ninjaService.listarTodosNinjas();
    }

    //alterar dadoos do ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizaNinja(id, ninjaAtualizado);
    }

    //deletar ninja
    @DeleteMapping("/deletarID/{id}")
    public void deletarPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}
