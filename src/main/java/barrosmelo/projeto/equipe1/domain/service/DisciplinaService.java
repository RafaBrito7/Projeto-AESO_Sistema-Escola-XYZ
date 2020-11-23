package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Disciplina;
import barrosmelo.projeto.equipe1.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements IDisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	@Override
	public void excluir(Long idDisciplina) {
		try {
			disciplinaRepository.deleteById(idDisciplina);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(idDisciplina);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(idDisciplina);
		}

	}

	@Override
	public Disciplina verificarExistencia(Long id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

		if (!disciplina.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}

		return disciplina.get();
	}

}
