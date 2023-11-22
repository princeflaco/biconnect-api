package br.com.fiap.biconnect.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.biconnect.models.dtos.get.list.ServicoListDTO;
import br.com.fiap.biconnect.services.ServicoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService service;

    @GetMapping
    public ResponseEntity<List<ServicoListDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}
