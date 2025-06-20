package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.dto.NinjaDTO;
import dev.java10x.CadastroDeNinjas.mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.model.Ninja;
import dev.java10x.CadastroDeNinjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarNinjas() {
        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninja pelo id
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    // Criar um ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        Ninja ninja = new NinjaMapper().map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<Ninja> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            Ninja ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            Ninja ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    // Deletar um ninja - Tem que ser um método void
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
