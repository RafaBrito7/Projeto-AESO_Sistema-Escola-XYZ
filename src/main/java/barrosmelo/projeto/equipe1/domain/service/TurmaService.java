package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Turma;
import barrosmelo.projeto.equipe1.domain.repository.TurmaRepository;

@Service
public class TurmaService implements ITurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	@Override
	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}

	@Override
	public void excluir(Long idTurma) {
		try {
			turmaRepository.deleteById(idTurma);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(idTurma);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(idTurma);
		}
	}

	@Override
	public Turma verificarExistencia(Long id) {
		Optional<Turma> turma = turmaRepository.findById(id);

		if (!turma.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}

		return turma.get();
	}

}
