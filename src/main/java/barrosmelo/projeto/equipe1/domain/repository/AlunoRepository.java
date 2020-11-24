package barrosmelo.projeto.equipe1.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("SELECT a FROM Aluno a WHERE a.credencial.idCredencial =:idCredencial")
	Optional<Aluno> findByCredencial(@Param("idCredencial") Long idCredencial);
}
