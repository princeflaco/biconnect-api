package br.com.fiap.biconnect.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.biconnect.models.dtos.get.PrestadorGetDTO;
import br.com.fiap.biconnect.models.dtos.get.ServicoGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorListDTO;
import br.com.fiap.biconnect.models.dtos.get.list.PrestadorServicoListDTO;
import br.com.fiap.biconnect.models.dtos.post.PrestadorPostDTO;
import br.com.fiap.biconnect.models.dtos.post.ServicoPostDTO;
import br.com.fiap.biconnect.models.dtos.put.PrestadorPutDTO;
import br.com.fiap.biconnect.models.dtos.put.ServicoPutDTO;
import br.com.fiap.biconnect.services.PrestadorService;
import br.com.fiap.biconnect.services.PrestadorServicoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("prestadores")
@RequiredArgsConstructor
public class PrestadorController {

    private final PrestadorService service;
    private final PrestadorServicoService pServicoService;

    @GetMapping
    public ResponseEntity<List<PrestadorListDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PrestadorPostDTO prestadorPostDTO) {
        log.info("Received payload: " + prestadorPostDTO);
        service.save(prestadorPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PrestadorGetDTO> details(@PathVariable String cpf) throws EntityNotFoundException {
        return ResponseEntity.ok(service.fetchFromCpf(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Void> update(@RequestBody PrestadorPutDTO prestadorPutDTO, @PathVariable String cpf)
            throws EntityNotFoundException {
        service.updateFromCpf(cpf, prestadorPutDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) throws EntityNotFoundException {
        service.deleteFromCpf(cpf);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{cpf}/servicos")
    public ResponseEntity<Void> create(@PathVariable String cpf, @RequestBody ServicoPostDTO servicoPostDTO) throws EntityNotFoundException {
        log.info("Received payload: " + servicoPostDTO);
        pServicoService.save(cpf, servicoPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}/servicos")
    public ResponseEntity<List<PrestadorServicoListDTO>> list(@PathVariable String cpf) throws EntityNotFoundException {
        return ResponseEntity.ok(pServicoService.list(cpf));
    }

    @GetMapping("/{cpf}/servicos/{id}")
    public ResponseEntity<ServicoGetDTO> fetchDetails(@PathVariable String cpf, @PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(pServicoService.fetchFromCpfThenId(id, cpf));
    }

    @PutMapping("/{cpf}/servicos/{id}")
    public ResponseEntity<Void> update(@RequestBody ServicoPutDTO servicoPutDTO, @PathVariable String cpf, @PathVariable Long id)
            throws EntityNotFoundException {
        pServicoService.atualizarServico(id, cpf, servicoPutDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{cpf}/servicos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String cpf, @PathVariable Long id) throws EntityNotFoundException {
        pServicoService.deleteFromCpfThenId(cpf, id);
        return ResponseEntity.noContent().build();
    }
}
