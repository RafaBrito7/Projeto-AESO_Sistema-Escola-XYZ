package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Curso;

public interface ICursoService {

	public Curso salvar(Curso curso);

	public void excluir(Long id);

	public Curso verificarExistencia(Long id);
}
