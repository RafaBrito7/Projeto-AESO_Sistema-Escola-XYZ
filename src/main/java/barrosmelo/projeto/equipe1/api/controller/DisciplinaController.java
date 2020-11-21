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

import barrosmelo.projeto.equipe1.domain.model.Disciplina;
import barrosmelo.projeto.equipe1.domain.repository.DisciplinaRepository;
import barrosmelo.projeto.equipe1.domain.service.DisciplinaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private DisciplinaService disciplinaService;

	@ApiOperation("Deve permitir salvar uma diciplina no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina salvar(@RequestBody Disciplina disciplina) {
		return disciplinaService.salvar(disciplina);
	}

	@ApiOperation("Deve retornar uma lista de disciplinas")
	@GetMapping
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
}
