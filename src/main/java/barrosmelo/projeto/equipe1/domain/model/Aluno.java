package barrosmelo.projeto.equipe1.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa {

	@Column(name = "numero_matricula")
	private String numeroMatricula;
	private String turma; //Lembrar alterar tipo para Turma
	private Double nota;
	private String permissao; //Lembrar alterar tipo para EnumPermissao

	public Aluno() {

	}

	public Aluno(String nome, String cpf, Date dataNascimento) {
		super(nome, cpf, dataNascimento);
	}

	public Aluno(String nome, String cpf, Date dataNascimento, String numeroMatricula, Double nota) {
		super(nome, cpf, dataNascimento);
		this.numeroMatricula = numeroMatricula;
		this.nota = nota;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroMatricula == null) ? 0 : numeroMatricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (numeroMatricula == null) {
			if (other.numeroMatricula != null)
				return false;
		} else if (!numeroMatricula.equals(other.numeroMatricula))
			return false;
		return true;
	}
	
}
