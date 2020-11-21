package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Turma;
import barrosmelo.projeto.equipe1.domain.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}
}
