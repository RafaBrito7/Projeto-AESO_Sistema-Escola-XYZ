package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

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

import barrosmelo.projeto.equipe1.domain.model.Professor;
import barrosmelo.projeto.equipe1.domain.repository.ProfessorRepository;
import barrosmelo.projeto.equipe1.domain.service.ProfessorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private ProfessorService professorService;

	@ApiOperation("Deve retornar uma lista de professores")
	@GetMapping
	public List<Professor> listar() {
		return professorRepository.findAll();
	}

	@ApiOperation("Deve retornar um professor a partir de um id determinado.")
	@GetMapping("/{idProfessor}")
	public ResponseEntity<Professor> buscar(@PathVariable Long idProfessor) {
		professorService.verificarExistencia(idProfessor);
		return ResponseEntity.ok(professorRepository.findById(idProfessor).get());
	}

	@ApiOperation("Deve salvar um professor")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Professor salvar(@RequestBody @Valid Professor professor) {
		return professorService.salvar(professor);
	}

	@ApiOperation("Deve atualizar um professor a partir de um id determinado.")
	@PutMapping("/{idProfessor}")
	public ResponseEntity<Professor> atualizar(@PathVariable Long idProfessor, @RequestBody Professor professor) {
		Professor professorEncontrado = professorService.verificarExistencia(idProfessor);

		BeanUtils.copyProperties(professor, professorEncontrado, "id");

		return ResponseEntity.ok(professorService.salvar(professorEncontrado));
	}

	@ApiOperation("Deve excluir um professor a partir de um id determinado.")
	@DeleteMapping("/{idProfessor}")
	public ResponseEntity<Professor> excluir(@PathVariable Long idProfessor) {
		professorService.excluir(idProfessor);
		return ResponseEntity.noContent().build();
	}
}
