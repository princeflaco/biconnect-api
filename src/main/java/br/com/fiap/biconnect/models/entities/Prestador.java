package br.com.fiap.biconnect.models.entities;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.biconnect.models.enums.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prestadores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prestador {
    @Id
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNasc;
    private LocalDate dataCriacao = LocalDate.now();
    private String email;
    private Genero genero;
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoPrestador endereco;
    @OneToMany(mappedBy = "prestador")
    private List<Servico> servicos;
}
