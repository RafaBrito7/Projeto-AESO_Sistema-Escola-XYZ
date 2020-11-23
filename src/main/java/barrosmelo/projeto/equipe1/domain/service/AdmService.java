package barrosmelo.projeto.equipe1.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.domain.model.Adm;
import barrosmelo.projeto.equipe1.domain.repository.AdmRepository;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class AdmService implements IAdmService {

	@Autowired
	private AdmRepository admRepository;

	@Autowired
	private CredencialRepository credencialRepository;

	@Override
	public Adm salvar(Adm adm) {
		return admRepository.save(adm);
	}

	@Override
	public void excluir(Long id) {
		try {
			Adm adm = verificarExistencia(id);
			admRepository.deleteById(id);
			credencialRepository.deleteById(adm.getCredencial().getIdCredencial());
			
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(id);
		}
	}

	@Override
	public Adm verificarExistencia(Long id) {
		Optional<Adm> adm = admRepository.findById(id);

		if (!adm.isPresent()) {
			throw new EntidadeNaoEncontradaException(id);
		}
		return adm.get();
	}
}
