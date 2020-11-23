package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Professor;
import barrosmelo.projeto.equipe1.domain.repository.ProfessorRepository;

@Service
public class ProfessorService implements IProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public void excluir(Long idProfessor) {
		try {
			professorRepository.deleteById(idProfessor);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(idProfessor);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(idProfessor);
		}
	}

	@Override
	public Professor verificarExistencia(Long id) {
		Optional<Professor> professor = professorRepository.findById(id);

		if (!professor.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}

		return professor.get();
	}
}
