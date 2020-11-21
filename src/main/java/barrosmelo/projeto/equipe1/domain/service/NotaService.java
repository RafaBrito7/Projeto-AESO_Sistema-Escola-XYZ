package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.api.exception.SemPermissaoException;
import barrosmelo.projeto.equipe1.domain.model.Adm;
import barrosmelo.projeto.equipe1.domain.model.Nota;
import barrosmelo.projeto.equipe1.domain.model.Professor;
import barrosmelo.projeto.equipe1.domain.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;

	public Nota salvar(Nota nota, Object object) {
		if (!(object instanceof Professor || object instanceof Adm)) {
			throw new SemPermissaoException("O usuário não possui permissão para executar esta operação.");
		}
		return notaRepository.save(nota);
	}
}
