package dev.java10x.CadastroDeNinjas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma missão pode ter vários ninjas
    // Mapeado por missão em Ninja
    @OneToMany(mappedBy = "missao")
    @JsonIgnore // Ignora o loop de serialização
    private List<Ninja> ninjas;
}
