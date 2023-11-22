package br.com.fiap.biconnect.services.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.biconnect.models.dtos.get.ServicoGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorServicoListDTO;
import br.com.fiap.biconnect.models.dtos.get.list.ServicoListDTO;
import br.com.fiap.biconnect.models.dtos.post.ServicoPostDTO;
import br.com.fiap.biconnect.models.dtos.put.ServicoPutDTO;
import br.com.fiap.biconnect.models.entities.Servico;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoConverter {
    private final ModelMapper mapper;

    public Servico apply(ServicoPostDTO servicoPostDTO) {
        return mapper.map(servicoPostDTO, Servico.class);
    }

    public void applyUpdate(Servico servico, ServicoPutDTO servicoPutDTO) {
        mapper.map(servicoPutDTO, servico);
    }

    public ServicoGetDTO applyFromServico(Servico servico) {
        return mapper.map(servico, ServicoGetDTO.class);
    }

    public PrestadorServicoListDTO applyFromServicoToPrestadorServicoList(Servico servico) {
        return mapper.map(servico, PrestadorServicoListDTO.class);
    }

    public ServicoListDTO applyFromServicoToList(Servico servico) {
        return mapper.map(servico, ServicoListDTO.class);
    }
}
