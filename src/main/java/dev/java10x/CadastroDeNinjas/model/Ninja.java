package dev.java10x.CadastroDeNinjas.model;

import jakarta.persistence.*;

import java.util.List;

// Transforma uma classe em uma entidade do BD
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // Um ninja pode ter apenas uma missão
    // Muitos ninjas tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missao_id") // Join com id da missão
    private Missao missao;

    public Ninja() {
    }

    public Ninja(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
