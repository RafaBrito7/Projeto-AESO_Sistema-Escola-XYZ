package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;
import java.util.Optional;

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

import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
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
	public Aluno salvar(@RequestBody @Valid Aluno aluno) {
		return alunoServive.salvar(aluno);
	}

	@ApiOperation("Deve retornar uma lista de alunos")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> lista() {
		return alunoRepository.findAll();
	}

	@ApiOperation("Deve retornar um aluno a partir de um determinado id")
	@GetMapping("buscar/{idAluno}")
	public ResponseEntity<Aluno> buscar(@PathVariable Long idAluno) {
		Optional<Aluno> aluno = alunoRepository.findById(idAluno);

		if (!aluno.isPresent()) {
			throw new EntidadeNaoEncontradaException(idAluno);
		}

		return ResponseEntity.ok(aluno.get());
	}

	@ApiOperation("Deve retornar um aluno a partir da credencial.")
	@GetMapping("/{idCredencial}")
	public ResponseEntity<Aluno> buscarPorCredencial(@PathVariable Long idCredencial) {
		Optional<Aluno> aluno = alunoRepository.findByCredencial(idCredencial);

		if (!aluno.isPresent()) {
			throw new EntidadeNaoEncontradaException(aluno.get().getCredencial().getIdCredencial());
		}

		aluno.get().setIsLogado(true);
		alunoServive.salvar(aluno.get());

		return ResponseEntity.ok(aluno.get());
	}

	@ApiOperation("Deve atulizar um aluno a partir de um determinado id.")
	@PutMapping("/{idAluno}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long idAluno, @RequestBody @Valid Aluno aluno) {
		Aluno alunoEncontrado = alunoServive.verificarExistencia(idAluno);

		BeanUtils.copyProperties(aluno, alunoEncontrado, "id");

		return ResponseEntity.ok(alunoServive.salvar(alunoEncontrado));
	}

	@ApiOperation("Deve excluir um aluno a partir de um determinado id.")
	@DeleteMapping("/{idAluno}")
	public ResponseEntity<Aluno> excluir(@PathVariable Long idAluno) {
		alunoServive.excluir(idAluno);
		return ResponseEntity.noContent().build();
	}
}
