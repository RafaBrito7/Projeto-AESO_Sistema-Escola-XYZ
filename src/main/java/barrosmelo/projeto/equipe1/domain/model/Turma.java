package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long idTurma;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
	private Curso curso;

	@Column(name = "nome_turma")
	private String nomeTurma;

	@Column(name = "ano_admissao")
	private String anoAdmissao;

	private Integer vagas;

	public Turma() {

	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getAnoAdmissao() {
		return anoAdmissao;
	}

	public void setAnoAdmissao(String anoAdmissao) {
		this.anoAdmissao = anoAdmissao;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}	

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}

}
