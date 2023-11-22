package br.com.fiap.biconnect.models.dtos.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPostDTO {
    private String estado;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
}
