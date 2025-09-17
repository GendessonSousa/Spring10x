package dev.Gendesson.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nesta rota!!";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodos(){
        return "Mostrar todos";
    }

    //Mostrar ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarNinjaPorId(){
        return "Mostrar por ID";
    }
    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "alterar por ID";
    }

    //Deletar ninja (DELETE)
    @DeleteMapping("deletarID")
    public String deletarNinjaPorId(){
        return "deletar por ID";
    }




}
