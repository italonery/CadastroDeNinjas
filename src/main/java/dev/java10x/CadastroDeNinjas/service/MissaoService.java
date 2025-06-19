package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.Missao;
import dev.java10x.CadastroDeNinjas.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<Missao> listarMissoes() {
        return missaoRepository.findAll();
    }

    public Missao listarMissaoPorId(Long id) {
        Optional<Missao> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public Missao criarMissao(Missao missao) {
        return missaoRepository.save(missao);
    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }
}
