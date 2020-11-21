package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class CredencialService {

	@Autowired
	private CredencialRepository credencialRepository;
	
	public Credencial autenticar(Credencial credencial) {
		if(credencial.getUsuario() != null && credencial.getSenha() != null) {
			return credencialRepository.findByUsuarioAndSenha(credencial.getUsuario(), credencial.getSenha());			
		}
		return null;
	}
}
