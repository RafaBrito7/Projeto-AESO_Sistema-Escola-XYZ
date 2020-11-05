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

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.domain.model.Serie;
import barrosmelo.projeto.equipe1.domain.repository.SerieRepository;
import barrosmelo.projeto.equipe1.domain.service.SerieService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/serie")
public class SerieController {

	@Autowired
	private SerieRepository serieRepository;

	@Autowired
	private SerieService serieService;

	@ApiOperation("Deve retornar uma serie ao salvar.")
	@PostMapping
	public ResponseEntity<Serie> salvar(@RequestBody Serie serie) {
		return ResponseEntity.ok(serieService.salvar(serie));
	}

	@ApiOperation("Deve retornar uma lista de séries")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Serie> listar() {
		return serieRepository.findAll();
	}

	@ApiOperation("Deve retornar uma série de acordo com o id passado pelo usuário.")
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Optional<Serie> serieEncontrada = serieRepository.findById(id);

		if (serieEncontrada.isPresent()) {
			return ResponseEntity.ok(serieEncontrada.get());
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Deve atualizar uma série")
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Serie serie) {
		Optional<Serie> serieEncontrada = serieRepository.findById(id);

		if (serieEncontrada.isPresent()) {
			BeanUtils.copyProperties(serie, serieEncontrada.get(), "serieId");
			serieService.salvar(serieEncontrada.get());
			return ResponseEntity.ok(serieEncontrada.get());
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Deve remover uma série a partir de um id fornecido pelo usuário")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Serie> serieEncontrada = serieRepository.findById(id);

		if (serieEncontrada.isPresent()) {
			try {
			serieService.remover(id);
			return ResponseEntity.noContent().build();}
			catch(EntidadeEmUsoException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(String.format("A série de id %d está em uso.", id));
			}
		}

		return ResponseEntity.notFound().build();
	}
}
