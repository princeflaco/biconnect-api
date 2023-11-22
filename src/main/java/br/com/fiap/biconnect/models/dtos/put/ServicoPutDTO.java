package br.com.fiap.biconnect.models.dtos.put;

import java.math.BigDecimal;

import br.com.fiap.biconnect.models.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPutDTO {
    private Categoria categoria;
    private String descricao;
    private BigDecimal valorHora;
}
