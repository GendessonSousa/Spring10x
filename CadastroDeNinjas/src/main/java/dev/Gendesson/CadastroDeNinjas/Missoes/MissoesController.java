package dev.Gendesson.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    //Get -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missões listadas";
    }
    //Post -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }
    //Put -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada";
    }
    //Delete -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada";
    }
}
