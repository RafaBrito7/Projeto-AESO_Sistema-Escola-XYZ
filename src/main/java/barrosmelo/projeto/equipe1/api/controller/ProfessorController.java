package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Nota;
import barrosmelo.projeto.equipe1.domain.model.Professor;
import barrosmelo.projeto.equipe1.domain.repository.ProfessorRepository;
import barrosmelo.projeto.equipe1.domain.service.NotaService;
import barrosmelo.projeto.equipe1.domain.service.ProfessorService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;	

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private NotaService notaService;

	@ApiOperation("Deve retornar uma lista de professores")
	@GetMapping
	public List<Professor> listar() {
		return professorRepository.findAll();
	}

	@ApiOperation("Deve salvar um professor")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Professor salvar(@RequestBody Professor professor) {
		return professorService.salvar(professor);
	}
	
	@ApiOperation("Deve permitir que o professor salve uma nota")
	@PostMapping("/cadastrar-nota")
	public ResponseEntity<Nota> salvarNota(@RequestBody Nota nota) {
		return ResponseEntity.ok(notaService.salvar(nota, this));
	}
}
