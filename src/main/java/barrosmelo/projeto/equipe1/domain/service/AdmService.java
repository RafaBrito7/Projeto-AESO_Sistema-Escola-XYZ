package barrosmelo.projeto.equipe1.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barrosmelo.projeto.equipe1.domain.model.Adm;
import barrosmelo.projeto.equipe1.domain.repository.AdmRepository;

@Service
public class AdmService {

	@Autowired
	private AdmRepository admRepository;
	
	public Adm salvar(Adm adm) {
		return admRepository.save(adm);
	}
}
