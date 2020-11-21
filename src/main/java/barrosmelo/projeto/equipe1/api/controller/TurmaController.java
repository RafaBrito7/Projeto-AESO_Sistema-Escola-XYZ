package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Turma;
import barrosmelo.projeto.equipe1.domain.repository.TurmaRepository;
import barrosmelo.projeto.equipe1.domain.service.TurmaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private TurmaService turmaService;

	@ApiOperation("Deve permitir salvar uma turma no banco de dados")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Turma salvar(@RequestBody Turma turma) {
		return turmaService.salvar(turma);
	}

	@ApiOperation("Deve retornar uma lista de turmas.")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Turma> listar() {
		return turmaRepository.findAll();
	}
}
