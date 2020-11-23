package barrosmelo.projeto.equipe1.domain.service;

import barrosmelo.projeto.equipe1.domain.model.Professor;

public interface IProfessorService {

	public Professor salvar(Professor professor);

	public void excluir(Long idProfessor);

	public Professor verificarExistencia(Long id);
}
