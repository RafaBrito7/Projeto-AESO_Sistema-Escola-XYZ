package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Professor;
import barrosmelo.projeto.equipe1.domain.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}

}
