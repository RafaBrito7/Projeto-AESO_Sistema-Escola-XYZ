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

	@ApiOperation("Deve retornar uma disciplina a partir de um id determinado.")
	@GetMapping("/{idDisciplina}")
	public ResponseEntity<Disciplina> buscar(@PathVariable Long idDisciplina) {
		Optional<Disciplina> disciplinaEncontrada = disciplinaRepository.findById(idDisciplina);

		if (!disciplinaEncontrada.isPresent()) {
			throw new EntidadeNaoEncontradaException(idDisciplina);
		}

		return ResponseEntity.ok(disciplinaEncontrada.get());
	}
	
	@ApiOperation("Deve permitir atualizar uma disciplina a partir de um id determinado.")
	@PutMapping("/{idDisciplina}")
	public ResponseEntity<Disciplina> atualizar(@PathVariable Long idDisciplina, @RequestBody Disciplina disciplina) {
		Disciplina disciplinaEncontrada = disciplinaService.verificarExistencia(idDisciplina);
		
		BeanUtils.copyProperties(disciplina , disciplinaEncontrada, "id");
		
		return ResponseEntity.ok(disciplinaEncontrada);
	}
	
	@ApiOperation("Deve permitir excluir uma disciplina a partir de um id determinado")
	@DeleteMapping("/{idDisciplina}")
	public void excluir(@PathVariable Long idDisciplina) {
		disciplinaService.excluir(idDisciplina);
	}
}
