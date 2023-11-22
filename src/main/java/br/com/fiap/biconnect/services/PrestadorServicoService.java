package br.com.fiap.biconnect.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.biconnect.db.PrestadorRepository;
import br.com.fiap.biconnect.db.ServicoRepository;
import br.com.fiap.biconnect.models.dtos.get.ServicoGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorServicoListDTO;
import br.com.fiap.biconnect.models.dtos.post.ServicoPostDTO;
import br.com.fiap.biconnect.models.dtos.put.ServicoPutDTO;
import br.com.fiap.biconnect.models.entities.Prestador;
import br.com.fiap.biconnect.models.entities.Servico;
import br.com.fiap.biconnect.services.converters.ServicoConverter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrestadorServicoService {
    private final ServicoRepository servicoRepository;
    private final PrestadorRepository prestadorRepository;
    private final ServicoConverter converter;

    @Transactional
    public void save(String cpf, ServicoPostDTO servicoPostDTO) {
        Prestador prestador = prestadorRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Prestador não encontrado"));
        Servico novoServico = converter.apply(servicoPostDTO);
        novoServico.setPrestador(prestador);
        Servico servicoSalvo = servicoRepository.saveAndFlush(novoServico);
        // Atualizar o lado do Prestador manualmente (gerenciamento de coleções
        // bidirecionais)
        prestador.getServicos().add(servicoSalvo);
        prestadorRepository.saveAndFlush(prestador);
    }

    @Transactional
    public void atualizarServico(Long servicoId, String cpfPrestador, ServicoPutDTO servicoAtualizado) {
        Servico servicoExistente = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        // Verifique se o CPF do prestador no serviço existente é igual ao fornecido
        if (!servicoExistente.getPrestador().getCpf().equals(cpfPrestador)) {
            throw new IllegalArgumentException("Este serviço não pertence ao prestador com CPF fornecido");
        }

        converter.applyUpdate(servicoExistente, servicoAtualizado);

        servicoRepository.save(servicoExistente);
    }

    public ServicoGetDTO fetchFromCpfThenId(Long servicoId, String cpfPrestador) {
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));

        // Verifique se o CPF do prestador no serviço existente é igual ao fornecido
        if (!servico.getPrestador().getCpf().equals(cpfPrestador)) {
            throw new IllegalArgumentException("Este serviço não pertence ao prestador com CPF fornecido");
        }

        return converter.applyFromServico(servico);
    }

    public List<PrestadorServicoListDTO> list(String cpf) {
        Prestador prestador = prestadorRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Prestador não encontrado"));
        return prestador.getServicos().stream().map(converter::applyFromServicoToPrestadorServicoList)
                .collect(Collectors.toList());
    }

    public void deleteFromCpfThenId(String cpf, Long servicoId) {
        fetchFromCpfThenId(servicoId, cpf);
        servicoRepository.deleteById(servicoId);
    }
}
