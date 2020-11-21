package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Disciplina;
import barrosmelo.projeto.equipe1.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
}
