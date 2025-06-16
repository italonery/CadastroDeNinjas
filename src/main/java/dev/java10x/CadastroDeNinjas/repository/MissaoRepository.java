package dev.java10x.CadastroDeNinjas.repository;

import dev.java10x.CadastroDeNinjas.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}
