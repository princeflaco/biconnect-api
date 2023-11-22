package br.com.fiap.biconnect.models.dtos.get;

import java.time.LocalDate;

import br.com.fiap.biconnect.models.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteGetDTO {
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNasc;
    private LocalDate dataCriacao;
    private String email;
    private Genero genero;
    private EnderecoGetDTO endereco;
}
