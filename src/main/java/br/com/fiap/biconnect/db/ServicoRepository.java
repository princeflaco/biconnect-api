package br.com.fiap.biconnect.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.biconnect.models.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
