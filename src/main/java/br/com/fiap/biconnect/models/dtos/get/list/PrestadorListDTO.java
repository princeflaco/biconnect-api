package br.com.fiap.biconnect.models.dtos.get.list;

import java.util.List;
import lombok.Data;

@Data
public class PrestadorListDTO {
    private String cpf;
    private String nome;
    private String email;
    private List<PrestadorServicoListDTO> servicos;
}
