package barrosmelo.projeto.equipe1.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

	@Query("from Turma t inner join t.curso")
	List<Turma> findAll();
}
