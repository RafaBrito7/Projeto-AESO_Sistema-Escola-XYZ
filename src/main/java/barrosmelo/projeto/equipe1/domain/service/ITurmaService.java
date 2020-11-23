package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Turma;

public interface ITurmaService {

	public Turma salvar(Turma turma);

	public void excluir(Long idTurma);

	public Turma verificarExistencia(Long id);
}
