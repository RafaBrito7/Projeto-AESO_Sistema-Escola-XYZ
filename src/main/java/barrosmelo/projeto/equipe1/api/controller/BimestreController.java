package barrosmelo.projeto.equipe1.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import barrosmelo.projeto.equipe1.domain.model.Bimestre;
import barrosmelo.projeto.equipe1.domain.repository.BimestreRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bimestre")
public class BimestreController {

	@Autowired
	private BimestreRepository bimestreRepository;

	@ApiOperation("Deve retornar uma lista de bimestres")
	@GetMapping
	public List<Bimestre> listar() {
		return bimestreRepository.findAll();
	}
}
