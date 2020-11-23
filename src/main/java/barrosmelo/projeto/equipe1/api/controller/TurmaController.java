package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;
import java.util.Optional;

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

import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
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

	@ApiOperation("Deve permitir salvar uma turma no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Turma salvar(@RequestBody Turma turma) {
		return turmaService.salvar(turma);
	}

	@ApiOperation("Deve retornar uma lista de turmas")
	@GetMapping
	public List<Turma> listar() {
		return turmaRepository.findAll();
	}

	@ApiOperation("Deve retornar uma turma a partir de um id determinado.")
	@GetMapping("/{idTurma}")
	public ResponseEntity<Turma> buscar(@PathVariable Long idTurma) {
		Optional<Turma> turmaEncontrada = turmaRepository.findById(idTurma);

		if (!turmaEncontrada.isPresent()) {
			throw new EntidadeNaoEncontradaException(idTurma);
		}

		return ResponseEntity.ok(turmaEncontrada.get());
	}

	@ApiOperation("Deve permitir atualizar uma turma a partir de um id determinado.")
	@PutMapping("/{idTurma}")
	public ResponseEntity<Turma> atualizar(@PathVariable Long idTurma, @RequestBody Turma turma) {
		Turma turmaEncontrada = turmaService.verificarExistencia(idTurma);

		BeanUtils.copyProperties(turma, turmaEncontrada, "id");

		return ResponseEntity.ok(turmaEncontrada);
	}

	@ApiOperation("Deve permitir excluir uma turma a partir de um id determinado")
	@DeleteMapping("/{idTurma}")
	public void excluir(@PathVariable Long idTurma) {
		turmaService.excluir(idTurma);
	}
}
