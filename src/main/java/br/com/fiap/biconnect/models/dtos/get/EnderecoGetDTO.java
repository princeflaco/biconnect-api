package br.com.fiap.biconnect.models.dtos.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoGetDTO {
    private Long id;
    private String estado;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String tipo;
}
