package dev.Gendesson.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota retorna uma mensagem de boas vindas para quem a acessa" )
    public String boasVindas(){
        return "Essa é minha primeira mensagem nesta rota!!";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Erro na criação do ninja!")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Rota retorna o ninja especificado pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID " + id + "/" + ninja.getNome() + "não foi encontrado!");
        }
        return ResponseEntity.ok(ninja);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Rota altera informações do ninja especificado pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "20", description = "Ninja encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<String> alterarNinjaPorId(
            @Parameter(description = "Usuário manda o Id pelo caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado pelo corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
        if (listarNinjasPorId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("O ninja de ID " + id + " - " + ninjaAtualizado.getNome() + " foi atualizado com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de ID " + id + " não foi encontrado!");
        }
    }

    //Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja de ID " + id + " foi deletado com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja do ID " + id + " não foi encontrado!");
        }
    }




}
