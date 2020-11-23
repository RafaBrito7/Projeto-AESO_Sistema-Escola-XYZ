package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Credencial;

public interface ICredencialService {

	public Credencial autenticar(Credencial credencial);

	public Credencial salvar(Credencial credencial);

	public Credencial verificarExistencia(Long id);

	public void excluir(Long id);
}
