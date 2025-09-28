package br.com.lognetbr.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lognetbr.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	@Query("""
			SELECT u FROM Usuario u
			WHERE u.email = :pemail
			""")
	Usuario findEmail(@Param("pemail") String email);
	
	@Query("""
			SELECT u FROM Usuario u
			WHERE u.email = :pemail AND u.senha = :psenha
			""")
	Usuario findEmailAndSenha(@Param("pemail") String email, @Param("psenha") String senha);	
	
}
