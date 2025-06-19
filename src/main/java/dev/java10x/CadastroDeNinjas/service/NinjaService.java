package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.mapper.NinjaMapper;
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
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        Ninja ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public Ninja alterarNinja(Long id, Ninja ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    // Deletar um ninja - Tem que ser um método void
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
