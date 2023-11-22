package br.com.fiap.biconnect.models.dtos.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessPOST {
    private Long id;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
