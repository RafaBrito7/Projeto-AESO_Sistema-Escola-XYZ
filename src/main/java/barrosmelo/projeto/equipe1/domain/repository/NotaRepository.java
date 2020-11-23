package barrosmelo.projeto.equipe1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{
	
}
