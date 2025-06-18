package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
