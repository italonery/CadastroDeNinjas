package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!");
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok().body(ninjas);
    }

    // Listar ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(ninja);
//            return ResponseEntity.ok().body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Objeto com ID: " + id + " não foi encontrado.");
        }
//        return ResponseEntity.notFound().build();

    }

    // Alterar ninja (UPDATE)
    @PatchMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            ninjaService.alterarNinja(id, ninjaDTO);
            return ResponseEntity.ok().body("Ninja alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Objeto com ID: " + id + " não foi encontrado.");
        }
//        return ResponseEntity.notFound().build();
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok().body("Ninja deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Objeto com ID: " + id + " não foi encontrado.");
        }
//        return ResponseEntity.notFound().build();
    }
}
