package br.com.fiap.biconnect.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos_prestadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPrestador {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String numero;
    private String complemento;
    @Column(nullable = false, length = 9)
    private String cep;
}
