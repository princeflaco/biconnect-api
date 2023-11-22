package br.com.fiap.biconnect.models.entities;

import java.time.LocalDate;

import br.com.fiap.biconnect.models.enums.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @Column(nullable = false, length = 11, unique = true, updatable = false)
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNasc;
    private LocalDate dataCriacao = LocalDate.now();
    private String email;
    private Genero genero;
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoCliente endereco;
}
