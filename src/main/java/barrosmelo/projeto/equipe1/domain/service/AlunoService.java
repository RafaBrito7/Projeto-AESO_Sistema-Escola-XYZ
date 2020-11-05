package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Aluno;
import barrosmelo.projeto.equipe1.domain.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
}
