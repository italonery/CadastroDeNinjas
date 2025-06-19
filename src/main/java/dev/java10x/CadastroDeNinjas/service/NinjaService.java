package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // @Autowired inicializa e controla o construtor da injeção de dependências
    // Por boas práticas, criar construtor ao invés de utilizazr Autowired
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<Ninja> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar ninja pelo id
    public Ninja listarNinjaPorId(Long id) {
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    // Criar um ninja
    public Ninja criarNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
