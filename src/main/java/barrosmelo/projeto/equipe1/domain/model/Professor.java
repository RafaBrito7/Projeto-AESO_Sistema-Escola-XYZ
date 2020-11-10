package barrosmelo.projeto.equipe1.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professor extends Pessoa{
	
	private String permissao;
	
	@ManyToMany
	@JoinTable(name = "turma_professor", joinColumns = @JoinColumn(name = "professor_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "turma_id", nullable = false))
	private List<Turma> turmas;

	
	public Professor() {

	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
