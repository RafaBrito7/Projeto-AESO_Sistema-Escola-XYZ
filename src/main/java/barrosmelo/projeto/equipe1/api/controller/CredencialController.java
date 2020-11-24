package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Credencial> autenticar(@RequestBody @Valid Credencial credencial) {
		Credencial credencialEncontrada = credencialService.autenticar(credencial);

		if (Objects.nonNull(credencialEncontrada)) {
			return ResponseEntity.ok(credencialEncontrada);
		}

		return ResponseEntity.badRequest().build();
	}

	@ApiOperation("Deve permitir inserir uma credencial no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Credencial salvar(@RequestBody @Valid Credencial credencial) {
		return credencialService.salvar(credencial);
	}

	@GetMapping
	public List<Credencial> listar() {
		return credencialRepository.findAll();
	}

	@ApiOperation("Deve permitir atualizar uma credencial a partir de um id específico.")
	@PutMapping("/{idCredencial}")
	public ResponseEntity<Credencial> atualizar(@PathVariable Long idCredencial,
			@RequestBody @Valid Credencial credencial) {
		Credencial credencialEncontrada = credencialService.verificarExistencia(idCredencial);

		BeanUtils.copyProperties(credencial, credencialEncontrada, "id");

		Credencial credencialSalva = credencialService.salvar(credencialEncontrada);

		return ResponseEntity.ok(credencialSalva);
	}

	@ApiOperation("Deve excluir uma credencial a partir de um id específico.")
	@DeleteMapping("{idCredencial}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long idCredencial) {
		credencialService.excluir(idCredencial);
	}
}
