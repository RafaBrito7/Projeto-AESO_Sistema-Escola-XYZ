package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Aluno;
import barrosmelo.projeto.equipe1.domain.repository.AlunoRepository;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CredencialRepository credencialRepository;

	@Override
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public void excluir(Long id) {
		try {
			Aluno aluno = verificarExistencia(id);
			alunoRepository.deleteById(id);
			credencialRepository.deleteById(aluno.getCredencial().getIdCredencial());
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(id);
		}

	}

	@Override
	public Aluno verificarExistencia(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);

		if (!aluno.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}
		return aluno.get();
	}

}