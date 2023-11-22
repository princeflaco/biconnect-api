package br.com.fiap.biconnect.models.dtos.get.list;

import java.math.BigDecimal;
import br.com.fiap.biconnect.models.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoListDTO {
    private Long id;
    private Categoria categoria;
    private String descricao;
    private BigDecimal valorHora;
    private String prestador;
}
