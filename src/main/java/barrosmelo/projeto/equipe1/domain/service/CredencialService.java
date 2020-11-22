package barrosmelo.projeto.equipe1.domain.service;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.RestricoesVioladasException;
import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class CredencialService {

	@Autowired
	private CredencialRepository credencialRepository;

	public Credencial autenticar(Credencial credencial) {

		if (credencial.getUsuario() != null && credencial.getSenha() != null) {
			return credencialRepository.findByUsuarioAndSenha(credencial.getUsuario(), credencial.getSenha());
		}
		return null;
	}
	
	public Credencial salvar(Credencial credencial) {
		try {
		return credencialRepository.save(credencial);
		}catch (ConstraintViolationException e) {
			throw new RestricoesVioladasException("Verifique se existe algum campo vazio, nulo ou em branco!");
		}
	}
}
