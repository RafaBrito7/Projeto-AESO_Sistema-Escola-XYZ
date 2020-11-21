package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;

@Service
public class CredencialService {

	@Autowired
	private CredencialRepository credencialRepository;
	
<<<<<<< HEAD
	public Credencial autenticar(String usuario, String senha) {
		if(usuario != null && senha != null) {
			return credencialRepository.findByUsuarioAndSenha(usuario, senha);			
=======
	public Credencial autenticar(Credencial credencial) {
		if(credencial.getUsuario() != null && credencial.getSenha() != null) {
			return credencialRepository.findByUsuarioAndSenha(credencial.getUsuario(), credencial.getSenha());			
>>>>>>> ece9115bd80d552ff9ed5b80d46aacd29e2627d1
		}
		return null;
	}
}
