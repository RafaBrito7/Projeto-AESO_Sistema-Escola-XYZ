package barrosmelo.projeto.equipe1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
