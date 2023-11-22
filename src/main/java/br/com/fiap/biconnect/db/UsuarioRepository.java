package br.com.fiap.biconnect.db;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.biconnect.models.entities.Cliente;

public interface UsuarioRepository extends JpaRepository<Cliente, String> {
}
