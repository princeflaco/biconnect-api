package br.com.fiap.biconnect.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.module.jdk8.Jdk8Module;
import org.modelmapper.module.jsr310.Jsr310Module;
import org.springframework.context.annotation.*;

import br.com.fiap.biconnect.models.dtos.get.list.ServicoListDTO;
import br.com.fiap.biconnect.models.entities.Servico;

@Configuration
public class Config {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper().registerModule(new Jsr310Module()).registerModule(new Jdk8Module());
        TypeMap<Servico, ServicoListDTO> typeMap = mapper.createTypeMap(Servico.class, ServicoListDTO.class);
        typeMap.addMappings(mappers -> 
            mappers.map(src -> src.getPrestador().getCpf(), ServicoListDTO::setPrestador)
        );
        return mapper;
    }
}
