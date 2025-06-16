package dev.java10x.CadastroDeNinjas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missao")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // Uma missão pode ter vários ninjas
    // Mapeado por missão em Ninja
    @OneToMany(mappedBy = "missao")
    private List<Ninja> ninjas;

    public Missao() {
    }

    public Missao(Long id, String nome, String dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
