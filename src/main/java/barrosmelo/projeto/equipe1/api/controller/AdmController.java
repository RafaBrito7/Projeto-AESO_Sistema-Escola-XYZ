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

import barrosmelo.projeto.equipe1.domain.model.Adm;
import barrosmelo.projeto.equipe1.domain.repository.AdmRepository;
import barrosmelo.projeto.equipe1.domain.service.AdmService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/adm")
public class AdmController {

	@Autowired
	private AdmService admService;
	@Autowired
	private AdmRepository admRepository;

	@ApiOperation("Deve permitir salvar um adm no banco de dados.")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Adm salvar(@RequestBody Adm adm) {
		return admService.salvar(adm);
	}

	@ApiOperation("Deve retornar uma lista de adms")
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Adm> lista() {
		return admRepository.findAll();
	}
}
