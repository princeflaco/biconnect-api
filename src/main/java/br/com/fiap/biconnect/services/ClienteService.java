package br.com.fiap.biconnect.services;

import org.springframework.stereotype.Service;

import br.com.fiap.biconnect.db.UsuarioRepository;
import br.com.fiap.biconnect.models.dtos.get.ClienteGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.ClienteListDTO;
import br.com.fiap.biconnect.models.dtos.put.ClientePutDTO;
import br.com.fiap.biconnect.models.dtos.post.ClientePostDTO;
import br.com.fiap.biconnect.models.entities.Cliente;
import br.com.fiap.biconnect.services.converters.ClienteConverter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteService {

    private final UsuarioRepository repository;
    private final ClienteConverter converter;

    public void save(ClientePostDTO clienteNovo) {
        log.info("\nPayload: {}", clienteNovo);
        Cliente cliente = converter.apply(clienteNovo);
        log.info("\nEntidade: {}", cliente);
        repository.save(cliente);
    }

    @Transactional
    public void updateFromCpf(String cpf, ClientePutDTO clienteAtualizado) {
        Cliente cliente = repository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        converter.applyUpdate(cliente, clienteAtualizado);
        repository.save(cliente);
    }

    public ClienteGetDTO fetchFromCpf(String cpf) {
        Cliente cliente = repository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return converter.applyFromCliente(cliente);
    }

    public List<ClienteListDTO> list() {
        return repository.findAll().stream().map(converter::applyFromClienteToList).collect(Collectors.toList());
    }

    public void deleteFromCpf(String cpf) {
        repository.deleteById(cpf);
    }
}
