package br.com.fiap.biconnect.models.dtos.post;

import java.time.LocalDate;

import br.com.fiap.biconnect.models.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePostDTO {
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNasc;
    private String email;
    private Genero genero;
    private EnderecoPostDTO endereco;
}
