package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.FuncaoPessoa;
import barrosmelo.projeto.equipe1.domain.repository.FuncaoPessoaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("funcao-pessoa")
public class FuncaoPessoaController {

	@Autowired
	private FuncaoPessoaRepository fpRepository;

	@ApiOperation("Deve retornar uma lista de função")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<FuncaoPessoa> listar() {
		return fpRepository.findAll();
	}
}
