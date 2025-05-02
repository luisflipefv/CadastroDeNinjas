package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaModel){
        NinjaDTO ninjaNovo = ninjaService.criarNinja(ninjaModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaNovo.getNome() + "ID: " + ninjaNovo.getId());
    }

    //procurar ninja por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostraTodosOsNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaId(id) != null){
            NinjaDTO ninja = ninjaService.listarNinjaId(id);
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuário não encontrado");
    }

    //mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarTodosNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarTodosNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //alterar dadoos do ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizaNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com is: "+ id +"não encontrado");
        }
    }

    //deletar ninja
    @DeleteMapping("/deletarID/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaId(id)!= null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Usuário  ID: "+ "Id " + "deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}
