package br.com.fiap.biconnect.models.entities;

import java.math.BigDecimal;

import br.com.fiap.biconnect.models.enums.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal valorHora;
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;
}
