package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Aluno;

public interface IAlunoService {

	public Aluno salvar(Aluno aluno);

	public void excluir(Long id);

	public Aluno verificarExistencia(Long id);
}
