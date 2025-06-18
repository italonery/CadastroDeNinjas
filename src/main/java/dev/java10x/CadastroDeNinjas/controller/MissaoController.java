package dev.java10x.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissao() {
        return "Missões listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }
}
