package barrosmelo.projeto.equipe1.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Credencial;
import barrosmelo.projeto.equipe1.domain.repository.CredencialRepository;
import barrosmelo.projeto.equipe1.domain.service.CredencialService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

	@Autowired
	private CredencialService credencialService;

	@Autowired
	private CredencialRepository credencialRepository;

	@ApiOperation("Deve retornar uma credencial se o usuario e senha passado pelo cliente for válido")
	@PostMapping("/autenticar")
	public ResponseEntity<Credencial> autenticar(@RequestBody Credencial credencial) {
		Credencial credencialEncontrada = credencialService.autenticar(credencial);

		if (Objects.nonNull(credencialEncontrada)) {
			return ResponseEntity.ok(credencialEncontrada);
		}

		return ResponseEntity.badRequest().build();
	}

	@ApiOperation("Deve permitir inserir uma credencial no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Credencial salvar(Credencial credencial) {
		return credencialService.salvar(credencial);
	}
}
