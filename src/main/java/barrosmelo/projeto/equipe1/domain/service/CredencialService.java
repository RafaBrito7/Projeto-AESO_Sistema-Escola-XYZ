package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class CredencialService implements ICredencialService {

	@Autowired
	private CredencialRepository credencialRepository;

	public Credencial autenticar(Credencial credencial) {

		if (credencial.getUsuario() != null && credencial.getSenha() != null && credencial.getTipoUsuario() != null) {
			return credencialRepository.findByUsuarioAndSenha(credencial.getUsuario(), credencial.getSenha());
		}
		return null;
	}

	public Credencial salvar(Credencial credencial) {
		return credencialRepository.save(credencial);
	}

	public Credencial verificarExistencia(Long id) {
		Optional<Credencial> credencial = credencialRepository.findById(id);

		if (!credencial.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}

		return credencial.get();
	}

	public void excluir(Long id) {
		try {
			credencialRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(id);
		}
	}
}
