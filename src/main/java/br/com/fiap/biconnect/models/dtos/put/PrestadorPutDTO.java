package br.com.fiap.biconnect.models.dtos.put;

import java.time.LocalDate;

import br.com.fiap.biconnect.models.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorPutDTO {
    private String nomeCompleto;
    private LocalDate dataNasc;
    private String email;
    private Genero genero;
    private EnderecoPutDTO endereco;
}
