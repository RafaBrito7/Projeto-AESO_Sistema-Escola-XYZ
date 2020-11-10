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

import barrosmelo.projeto.equipe1.domain.model.Pessoa;
import barrosmelo.projeto.equipe1.domain.repository.PessoaRepository;
import barrosmelo.projeto.equipe1.domain.service.PessoaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;
	
	@ApiOperation("Deve retornar uma lista de pessoas")
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@ApiOperation("Deve salvar uma pessoa")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa salvar(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}
}
