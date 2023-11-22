package br.com.fiap.biconnect.services.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.biconnect.models.dtos.get.PrestadorGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorListDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorServicoListDTO;
import br.com.fiap.biconnect.models.dtos.post.PrestadorPostDTO;
import br.com.fiap.biconnect.models.dtos.put.PrestadorPutDTO;
import br.com.fiap.biconnect.models.entities.Prestador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PrestadorConverter {
    private final ModelMapper mapper;

    public Prestador apply(PrestadorPostDTO prestadorNovo) {
        return mapper.map(prestadorNovo, Prestador.class);
    }

    public void applyUpdate(Prestador prestador, PrestadorPutDTO prestadorAtualizado) {
        mapper.map(prestadorAtualizado, prestador);
    }

    public PrestadorGetDTO applyFromPrestador(Prestador prestador) {
        return mapper.map(prestador, PrestadorGetDTO.class);
    }

    public PrestadorListDTO applyFromPrestadorToList(Prestador prestador) {
        PrestadorListDTO listaPrestadores = mapper.map(prestador, PrestadorListDTO.class);
        log.debug("Prestador convertido para o padrão de listagem: " + listaPrestadores);
        List<PrestadorServicoListDTO> listaServicos = prestador.getServicos().stream()
                .map(servico -> mapper.map(servico, PrestadorServicoListDTO.class))
                .collect(Collectors.toList());
        listaPrestadores.setServicos(listaServicos);
        return listaPrestadores;
    }
}
