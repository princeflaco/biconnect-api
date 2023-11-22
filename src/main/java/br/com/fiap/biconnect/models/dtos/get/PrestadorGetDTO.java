package br.com.fiap.biconnect.models.dtos.get;

import java.time.LocalDate;
import java.util.List;
import br.com.fiap.biconnect.models.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorGetDTO {
    private String cpf;
    private String nome;
    private LocalDate dataNasc;
    private LocalDate dataCriacao;
    private String email;
    private Genero genero;
    private EnderecoGetDTO endereco;
    private List<ServicoGetDTO> servicos;
}
