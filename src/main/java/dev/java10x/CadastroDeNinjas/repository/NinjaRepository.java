package dev.java10x.CadastroDeNinjas.repository;

import dev.java10x.CadastroDeNinjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
