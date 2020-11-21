package barrosmelo.projeto.equipe1.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.service.CredencialService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

	@Autowired
	private CredencialService credencialService;

<<<<<<< HEAD
	@GetMapping("autenticar/{usuario}/{senha}")
	public ResponseEntity<Credencial> autenticar(@PathVariable("usuario") String usuario, @PathVariable("senha") String senha) {
		return ResponseEntity.ok(credencialService.autenticar(usuario, senha));
=======
	@PostMapping("/autenticar")
	public ResponseEntity<Credencial> autenticar(@RequestBody Credencial credencial) {
		return ResponseEntity.ok(credencialService.autenticar(credencial));
>>>>>>> ece9115bd80d552ff9ed5b80d46aacd29e2627d1
	}
}
