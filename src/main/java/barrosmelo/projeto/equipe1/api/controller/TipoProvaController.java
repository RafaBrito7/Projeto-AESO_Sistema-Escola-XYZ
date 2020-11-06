package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.TipoProva;
import barrosmelo.projeto.equipe1.domain.repository.TipoProvaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tipo-prova")
public class TipoProvaController {

	@Autowired
	private TipoProvaRepository tpRepository;

	@ApiOperation("Deve retornar uma lista contendo os tipos de prova")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<TipoProva> listar() {
		return tpRepository.findAll();
	}
}
