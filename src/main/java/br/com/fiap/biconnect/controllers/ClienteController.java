package br.com.fiap.biconnect.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.biconnect.models.dtos.get.ClienteGetDTO;
import br.com.fiap.biconnect.models.dtos.get.list.ClienteListDTO;
import br.com.fiap.biconnect.models.dtos.post.ClientePostDTO;
import br.com.fiap.biconnect.models.dtos.put.ClientePutDTO;
import br.com.fiap.biconnect.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteListDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ClientePostDTO usuarioPostDTO) {
        log.info("Received payload: " + usuarioPostDTO);
        service.save(usuarioPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteGetDTO> details(@PathVariable String cpf) throws EntityNotFoundException {
        return ResponseEntity.ok(service.fetchFromCpf(cpf));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Void> update(@RequestBody ClientePutDTO usuarioPutDTO, @PathVariable String cpf)
            throws EntityNotFoundException {
        service.updateFromCpf(cpf, usuarioPutDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) throws EntityNotFoundException {
        service.deleteFromCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
