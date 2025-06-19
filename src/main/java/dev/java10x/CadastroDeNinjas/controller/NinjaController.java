package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // adicionar ninja (CREATE)
    @PostMapping("/criar")
    public Ninja criarNinja(@RequestBody Ninja ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<Ninja> listarNinjas() {
        return  ninjaService.listarNinjas();
    }

    // Listar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public Ninja listarNinjaPorId(@PathVariable Long id) {
        return  ninjaService.listarNinjaPorId(id);
    }

    // Alterar ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Ninja alterado com sucesso";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado com sucesso";
    }
}
