package br.com.fiap.biconnect.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.biconnect.models.entities.EnderecoPrestador;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoPrestador, Long> {
}
