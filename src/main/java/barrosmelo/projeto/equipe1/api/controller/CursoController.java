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

import barrosmelo.projeto.equipe1.domain.model.Curso;
import barrosmelo.projeto.equipe1.domain.repository.CursoRepository;
import barrosmelo.projeto.equipe1.domain.service.CursoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoRepository cursoRepository;

	@ApiOperation("End point responsável por salvar um novo curso")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Curso salvarCurso(@RequestBody Curso curso) {
		return cursoService.salvar(curso);
	}

	@ApiOperation("Deve retornar uma lista de cursos")
	@GetMapping
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@ApiOperation("Deve retornar um curso de um id específico")
	@GetMapping("/{idCurso}")
	public ResponseEntity<Curso> buscar(@PathVariable Long idCurso) {
		Optional<Curso> cursoEncontrado = cursoRepository.findById(idCurso);

		if (cursoEncontrado.isPresent()) {
			return ResponseEntity.ok(cursoEncontrado.get());
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Deve atualizar um curso de id específico")
	@PutMapping("/{idCurso}")
	public ResponseEntity<Curso> atualizarCurso(@PathVariable Long idCurso, @RequestBody Curso cursoAtualizado) {
		Optional<Curso> cursoExistente = cursoRepository.findById(idCurso);

		if (cursoExistente.isPresent()) {
			BeanUtils.copyProperties(cursoAtualizado, cursoExistente.get(), "id");
			cursoService.salvar(cursoExistente.get());
			return ResponseEntity.ok(cursoExistente.get());
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Deve excluir um curso com um id específico")
	@DeleteMapping("/{idCurso}")
	public ResponseEntity<Curso> remover(@PathVariable Long idCurso) {
		Optional<Curso> cursoEncontrado = cursoRepository.findById(idCurso);

		if (cursoEncontrado.isPresent()) {
			cursoService.remover(idCurso);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
