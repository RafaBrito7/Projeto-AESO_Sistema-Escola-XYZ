package barrosmelo.projeto.equipe1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long>{
	Credencial findByUsuarioAndSenha(String usuario, String senha);
}
