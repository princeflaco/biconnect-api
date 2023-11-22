package br.com.fiap.biconnect.services.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.biconnect.models.dtos.get.ClienteGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.ClienteListDTO;
import br.com.fiap.biconnect.models.dtos.post.ClientePostDTO;
import br.com.fiap.biconnect.models.dtos.put.ClientePutDTO;
import br.com.fiap.biconnect.models.entities.Cliente;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteConverter {

    private final ModelMapper mapper;

    public Cliente apply(ClientePostDTO cliente) {
        return mapper.map(cliente, Cliente.class);
    }

    public void applyUpdate(Cliente cliente, ClientePutDTO clienteAtualizado) {
        mapper.map(clienteAtualizado, cliente);
    }

    public ClienteGetDTO applyFromCliente(Cliente cliente) {
        return mapper.map(cliente, ClienteGetDTO.class);
    }

    public ClienteListDTO applyFromClienteToList(Cliente cliente) {
        return mapper.map(cliente, ClienteListDTO.class);
    }
}
