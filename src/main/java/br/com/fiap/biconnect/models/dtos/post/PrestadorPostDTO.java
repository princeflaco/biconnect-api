package br.com.fiap.biconnect.models.dtos.post;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrestadorPostDTO {
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNasc;
    private String email;
    private EnderecoPostDTO endereco;
}
