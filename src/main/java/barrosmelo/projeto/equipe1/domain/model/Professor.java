package barrosmelo.projeto.equipe1.domain.model;

public class Professor {

	private Turma turma;
	
	private String permissao;
	
	public Professor() {
		
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
}
