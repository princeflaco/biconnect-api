package br.com.fiap.biconnect.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.biconnect.db.PrestadorRepository;
import br.com.fiap.biconnect.models.dtos.get.PrestadorGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorListDTO;
import br.com.fiap.biconnect.models.dtos.post.PrestadorPostDTO;
import br.com.fiap.biconnect.models.dtos.put.PrestadorPutDTO;
import br.com.fiap.biconnect.models.entities.Prestador;
import br.com.fiap.biconnect.services.converters.PrestadorConverter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrestadorService {
    private final PrestadorRepository repository;
    private final PrestadorConverter converter;

    public void save(PrestadorPostDTO prestadorNovo) {
        log.info("\nPayload: {}", prestadorNovo);
        Prestador prestador = converter.apply(prestadorNovo);
        log.info("\nEntidade: {}", prestador);
        repository.save(prestador);
    }

    @Transactional
    public void updateFromCpf(String cpf, PrestadorPutDTO prestadorAtualizado) {
        Prestador prestador = repository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Prestador não encontrado"));
        converter.applyUpdate(prestador, prestadorAtualizado);
        repository.save(prestador);
    }

    public PrestadorGetDTO fetchFromCpf(String cpf) {
        Prestador prestador = repository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Prestador não encontrado"));
        return converter.applyFromPrestador(prestador);
    }

    public List<PrestadorListDTO> list() {
        return repository.findAll().stream().map(converter::applyFromPrestadorToList).collect(Collectors.toList());
    }

    public void deleteFromCpf(String cpf) {
        repository.deleteById(cpf);
    }
}
