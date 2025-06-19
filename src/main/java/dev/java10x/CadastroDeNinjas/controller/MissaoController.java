package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.model.Missao;
import dev.java10x.CadastroDeNinjas.service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<Missao> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public Missao listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PostMapping("/criar")
    public Missao criarMissao(@RequestBody Missao missao) {
        return missaoService.criarMissao(missao);
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissao(id);
    }
}
