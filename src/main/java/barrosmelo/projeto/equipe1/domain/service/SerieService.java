package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.domain.model.Serie;
import barrosmelo.projeto.equipe1.domain.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository serieRepository;

	public Serie salvar(Serie serie) {
		return serieRepository.save(serie);
	}

	public void remover(Long id) {
		try {
		serieRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("A série de id %d está em uso.", id));
		}
	}
}
