package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Disciplina;

public interface IDisciplinaService {

	public Disciplina salvar(Disciplina disciplina);

	public void excluir(Long idDisciplina);

	public Disciplina verificarExistencia(Long id);
}
