package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vidas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo ninja", description = "Rota cria um ninja e insere no banco de dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!");
    }

    @GetMapping("/listar")
//    @Operation(summary = "Listar todos os ninjas", description = "Rota lista todos os ninjas cadastrados")
//    @ApiResponses
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok().body(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninja pelo id", description = "Rota retorna o ninja buscado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
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

    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Alterar ninja", description = "Rota altera o ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado!")
    })
    public ResponseEntity<String> alterarNinja(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja no corpo da requisição")
            @RequestBody NinjaDTO ninjaDTO) {
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
