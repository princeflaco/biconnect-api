package br.com.fiap.biconnect.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.biconnect.db.ServicoRepository;
import br.com.fiap.biconnect.models.dtos.get.list.ServicoListDTO;
import br.com.fiap.biconnect.services.converters.ServicoConverter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicoService {
    private final ServicoRepository servicoRepository;
    private final ServicoConverter converter;
    
    public List<ServicoListDTO> list() {
        return servicoRepository.findAll().stream().map(converter::applyFromServicoToList).collect(Collectors.toList());
    }
}
