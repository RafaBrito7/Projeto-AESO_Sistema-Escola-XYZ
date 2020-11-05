package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Aluno;
import barrosmelo.projeto.equipe1.domain.repository.AlunoRepository;
import barrosmelo.projeto.equipe1.domain.service.AlunoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private AlunoService alunoServive;

	@ApiOperation("Deve permitir salvar um aluno no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno salvar(Aluno aluno) {
		return alunoServive.salvar(aluno);
	}

	@ApiOperation("Deve retornar uma lista de alunos")
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Aluno> lista() {
		return alunoRepository.findAll();
	}
}
