package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Curso;
import barrosmelo.projeto.equipe1.domain.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void remover(Long idCurso) {
		cursoRepository.deleteById(idCurso);
	}
}
