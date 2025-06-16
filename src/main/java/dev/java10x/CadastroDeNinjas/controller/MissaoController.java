package dev.java10x.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    @GetMapping("/list")
    public String listarMissao() {
        return "Missões listadas com sucesso";
    }
}
