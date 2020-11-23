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
	public Adm salvar(@RequestBody @Valid Adm adm) {
		return admService.salvar(adm);
	}

	@ApiOperation("Deve retornar uma lista de adms")
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Adm> lista() {
		return admRepository.findAll();
	}

	@ApiOperation("Deve permitir atualizar um adm a partir de um determinado id.")
	@PutMapping("/{idAdm}")
	public ResponseEntity<Adm> atualizar(@PathVariable Long idAdm, @RequestBody Adm adm) {
		Adm admEncontrado = admService.verificarExistencia(idAdm);

		BeanUtils.copyProperties(adm, admEncontrado, "id");

		return ResponseEntity.ok(admService.salvar(admEncontrado));
	}

	@ApiOperation("Deve permitir excluir um adm a partir de um id específico.")
	@DeleteMapping("/{idAdm}")
	public ResponseEntity<Adm> excluir(@PathVariable Long idAdm) {
		admService.excluir(idAdm);

		return ResponseEntity.noContent().build();
	}	
}
