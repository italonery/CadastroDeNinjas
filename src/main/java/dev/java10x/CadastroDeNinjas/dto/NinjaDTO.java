package dev.java10x.CadastroDeNinjas.dto;

import dev.java10x.CadastroDeNinjas.model.Missao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private Missao missao;
    private String rank;
}

