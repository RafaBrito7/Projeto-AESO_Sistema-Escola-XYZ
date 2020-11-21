package barrosmelo.projeto.equipe1.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.service.CredencialService;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

	@Autowired
	private CredencialService credencialService;

	@GetMapping("autenticar/{usuario}/{senha}")
	public ResponseEntity<Credencial> autenticar(@PathVariable("usuario") String usuario, @PathVariable("senha") String senha) {
		return ResponseEntity.ok(credencialService.autencicar(usuario, senha));
	}
}
