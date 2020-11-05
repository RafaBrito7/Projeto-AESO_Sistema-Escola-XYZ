package barrosmelo.projeto.equipe1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import barrosmelo.projeto.equipe1.domain.model.Bimestre;

@Repository
public interface BimestreRepository extends JpaRepository<Bimestre, Long>{

}
