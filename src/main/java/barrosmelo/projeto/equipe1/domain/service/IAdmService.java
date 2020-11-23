package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Adm;

public interface IAdmService {

	public Adm salvar(Adm adm);

	public void excluir(Long id);

	public Adm verificarExistencia(Long id);
}
