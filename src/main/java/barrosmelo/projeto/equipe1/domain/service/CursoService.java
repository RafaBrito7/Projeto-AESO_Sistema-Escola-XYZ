package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Curso;
import barrosmelo.projeto.equipe1.domain.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public void excluir(Long id) {
		try {
			cursoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(id);
		}

	}

	@Override
	public Curso verificarExistencia(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);

		if (!curso.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}

		return curso.get();
	}

}
